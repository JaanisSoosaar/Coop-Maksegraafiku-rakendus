<template>
  <table v-if="loan.length > 0">
    <thead>
    <tr>
      <th>Aasta</th>
      <th>Yearly EMI</th>
      <th>Yearly Principal</th>
      <th>Aastane intress</th>
      <th>Kuu</th>
      <th>Põhiosa makse</th>
      <th>Monthly Principal</th>
      <th>Intress</th>
      <th>Põhiosa jääk</th>
    </tr>
    </thead>
    <tbody>
    <tr :key="year.year">
      <td>{{ year.year }}</td>
      <td>{{ year.yearly_emi }}</td>
      <td>{{ year.yearly_principal }}</td>
      <td>{{ year.yearly_interest }}</td>
      <template v-for="month in year.monthly_breakdown" :key="month.month">
        <tr>
          <td>{{ month.month }}</td>
          <td>{{ month.monthly_emi }}</td>
          <td>{{ month.monthly_principal }}</td>
          <td>{{ month.monthly_interest }}</td>
          <td>{{ month.remaining_loan_amount }}</td>
        </tr>
      </template>
    </tr>
    </tbody>
  </table>
</template>


<script>

import { ref, onMounted,/* watch */ } from 'vue';
import axios from 'axios';

export default {
props: ['onNewLoan'],
setup(/* props */) {
const loan = ref([]);

  const fetchLoan = async () => {
    try {
      console.log('Fetching loan...');
      const response = await axios.post('/api/calculateEmi', {
        loan_amount: 50000,
        interest_rate: 6,
        loan_term: 3
      },
          {timeout: 5000,
      });
      console.log('API response:', response.data);
      if (response.data.emi_breakdown) {
        loan.value = response.data.emi_breakdown.map(year => ({
          ...year,
          monthly_breakdown: year.monthly_breakdown.map(month => ({
            ...month,
            remaining_loan_amount: month.remaining_loan_amount.toFixed(2),
            monthly_principal: month.monthly_principal.toFixed(2),
            monthly_interest: month.monthly_interest.toFixed(2),
            monthly_emi: month.monthly_emi.toFixed(2),
          })),
        }));
        console.log('Fetched loan:', loan.value)
      } else {
        console.error('Unexpected API response:', response);
      }
    } catch (error) {
      console.error('Failed to fetch loan:', error);
    }
  };

    /*
    //TODO: Implement this
    watch(props.onNewLoan, (newLoan) => {
    if (newLoan) {
      // check if newLoan already exists
      // go to API and fetch the new loan
    }
    });

     */

    onMounted(fetchLoan);

    return {
      loan,
    };
  },
};
</script>