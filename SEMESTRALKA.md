# Zadání semestrální práce

Cílem je vytvořit jednoduchou účetní aplikaci.

Základní vlastnosti:

* webová aplikace
* data v libovolné databázi
* ověřování uživatelů/rolí
* veřejný/neveřejný obsah
* responsivní chování

## Povinné funkce

1. Evidence kontaktů (adresář obchodních partnerů) - potřebná role **účetní**
2. Evidence přijatých a vydaných faktur
	* doklad obsahuje běžné hlavičky s identifikací obou stran a nezbytnými údaji faktury
	* doklad obsahuje libovolný počet řádků s položkami - název, jednotková cena, množství + zobrazení celkové ceny
	* u dokladu se zobrazuje rekapitulace
	* role **účetní** smí doklady zakládat, upravovat, stornovat (faktury se nemažou)
	* ostatní uživatelé (s rolí admin nebo bez role) smějí pouze prohlížet
3. Správa uživatelů (dvě vestavěné role - admin, účetní) - potřebná role **admin**
	* založení, úprava, mazání uživatelů, změna hesla bez nutnosti zadat stávající heslo, změna přiřazených rolí
4. Správa identifikačních údajů účtované firmy - potřebná role **účetní**
5. Každý přihlášený uživatel si může změnit svoje heslo s nutností zadat i stávající heslo

## Bonusové funkce
* role **jednatel** - identifikační údaje účtované firmy smí upravovat pouze jednatel, účetní to právo nemá
* více účtovaných firem, spravovat účtované firmy smí jednatel, pokud se rozhodnete roli implementovat, příp. účetní, pokud jednatele implementovat nebudete
* ceník - databáze zboží/výkonů s cenami
	* položku ceníku lze vybrat při zakládání/editaci řádku dokladu a slouží k předvyplnění údajů
