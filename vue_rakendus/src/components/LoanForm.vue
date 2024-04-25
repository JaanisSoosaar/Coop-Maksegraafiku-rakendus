<template>
  <form @submit.prevent="submitForm">
    <div>
      <label for="loanAmount">Laenusumma:</label>
      <input type="number" id="loanAmount" v-model="loanAmount" min="20000" max="300000" required />
      <p v-if="errors.loanAmount">{{ errors.loanAmount }}</p>
    </div>
    <div>
      <label for="period">Periood (aastates):</label>
      <input type="number" id="period" v-model="period" min="1" required />
      <p v-if="errors.period">{{ errors.period }}</p>
    </div>
    <div>
      <label for="startDate">Alguskuupäev (valikuline):</label>
      <input type="date" id="startDate" v-model="startDate" :min="today" />
      <p v-if="errors.startDate">{{ errors.startDate }}</p>
    </div>
    <button type="submit">Submit</button>
  </form>
</template>

<script>
import { ref, computed } from 'vue';

export default {
  setup(props, {emit}) {
    const loanAmount = ref('');
    const period = ref('');
    const startDate = ref('');
    const errors = ref({});

    const today = computed(() => {
      const date = new Date();
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
    });

    const validateForm = () => {
      let valid = true;
      errors.value = {};

      if (!loanAmount.value || loanAmount.value < 20000 || loanAmount.value > 300000) {
        errors.value.loanAmount = 'Laenusumma peab olema vahemikus 20000 - 300000';
        valid = false;
      }

      if (!period.value || period.value < 1) {
        errors.value.period = 'Periood peab olema vähemalt 1 aasta';
        valid = false;
      }

      if (startDate.value && startDate.value < today.value) {
        errors.value.startDate = 'Alguskuupäev ei tohi olla minevikus';
        valid = false;
      }

      return valid;
    };
    const submitForm = () => {
      if (validateForm()) {
        const newLoan = {
          laenusumma: loanAmount.value,
          perioodKuudes: period.value * 12,
          alguskuupäev: startDate.value,
        };
        emit('new-loan', newLoan); // Emit the new-loan event
      }
    };

    return {
      loanAmount,
      period,
      startDate,
      errors,
      today,
      submitForm,
      emit,
    };
  },
};
</script>