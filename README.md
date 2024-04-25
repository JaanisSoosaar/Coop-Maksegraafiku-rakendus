# Coop-Maksegraafiku-rakendus

#### NB! Ei jõudnud kahjuks enamus nõudeid täita, sest API-de tööle saamisega tekkis palju probleeme, mille tõttu sattusin ajahätta. Lõpuks jäigi nii, et EmiCalculatorApi-t tööle ei saanud, seega rakendus ei täida absoluutselt nõutud  funktsionaalsust.

### Rakenduse kirjeldus
Tegemist on laenu maksegraafiku arvutamise rakendusega, mis kasutab 2-te API-t. <br>
Maksegraafiku integratsiooni api: https://rapidapi.com/arjansolanki25-xtEh4AYAGOi/api/smart-emi-calculator <br>
Euribori api: https://rapidapi.com/lrdavocado-O3qmwiGJQwR/api/euribor <br>

### Rakenduse käivitamine

1. Kloonige see repo enda arvutisse
2. Leidke rapidapi.com-st API võtmed, ning asetage need vastavatesse failidesse, mis asuvad: <br>
   (src/main/java/fs/spring/vue/maksegraafiku_rakendus/service/EmiCalculatorService.java) - reale 26, kus on kirjas "YOUR_API_KEY_HERE"<br>
   (src/main/java/fs/spring/vue/maksegraafiku_rakendus/service/EuriborService.java) - reale 23, kus on kirjas "YOUR_API_KEY_HERE"<br>
3. Käivitage fail nimega "MaksegraafikuRakendusApplication.java", mis asub <br>
("src/main/java/fs/spring/vue/maksegraafiku_rakendus/MaksegraafikuRakendusApplication.java") <br> 
See fail käivitab Spring Boot rakenduse (Backend).
4. Avage terminal, ning liikuge kausta nimega "vue_rakendus".
5. Käivitage käsk "npm install", et installida kõik vajalikud sõltuvused.
6. Käivitage käsk "npm run serve", et käivitada Vue rakendus (Frontend).
7. Avage brauser, ning rakendust näeb aadressil "http://localhost:8081/".
8. Andmebaasi näeb aadressil "http://localhost:8080/h2-console" (Ei jõudnud otseselt seda veel implementeerida.)