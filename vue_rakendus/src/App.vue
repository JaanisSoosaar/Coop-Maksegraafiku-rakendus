// App.vue

<template>
  <div>
    <LoanForm @new-loan="addNewLoan" />
    <br>
    <LoanTable :onNewLoan="newLoan" />
  </div>
</template>

<script>
import LoanForm from '@/components/LoanForm.vue';
import LoanTable from '@/components/LoanTable.vue';

export default {
  name: 'App',
  components: {
    LoanForm,
    LoanTable,
  },
  data() {
    return {
      newLoan: null,
    };
  },
  methods: {
    addNewLoan(newLoan) {
      this.newLoan = newLoan;
    },
  },
};
</script>