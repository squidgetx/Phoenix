#include "itemnames.asm"
name .equ 1
checkFlag .equ 2
checkItem .equ 3
setFlag .equ 4
resFlag .equ 5
newLine .equ 6
pause .equ 7
getItem .equ 8
battle .equ 9
changeTile .equ 10
store .equ 11
input .equ 12
jump .equ 13
warp .equ 14
getMoney .equ 15
heal .equ 16
specialBattle .equ 17
Start:
.dw convo0,convo1,convo2,convo3,convo4,convo5,convo6,convo7,convo8,convo9,convo10,convo11,convo12,convo13
convo0:
.db "...",0
convo1:
.db "Are you all right?",pause,"We found you unconscious over there by the burnt trees. "
.db "Say, you look kinda strange. Are you from around here?",0
convo2:
.db "CAPITOL CITY- SOUTHEAST 7 KM",0
convo3:
.db "King's Outpost",0
convo4:
.db "CAPITOL CITY- SOUTH 2KM",0
convo5:
.db "KING'S ORDER- All subjects are to report to the Capitol City immediately.",0
convo6:
.db "VISITORS MUST UNDERGO SECURITY CLEARANCE!",0
convo7:
.db "NO TRESPASSING- PRIVATE PROPERTY OF THE CAPITOL",0
convo8:
.db ".........",pause,specialBattle,2,20,warp,23,0,12,2,0
convo9:
.db "This gate is locked.",0
convo10:
.db checkFlag \ .dw $0001, skip1
.db "Got a steak!",getItem,steak,setFlag \ .dw $0001 \ .db 0
skip1:
.db "It's empty",0
convo11:
.db "That bastard imperial regime has been cannibalizing all the weaponry in the area. "
.db "They're just trying to keep us all scared and reliant on them. "
.db "Luckily I got a few pieces left."
.db store, 6
.db Dagger \  .dw 20
.db Shortbow \ .dw 20
.db Knives \ .dw 20
.db Oak_Staff \ .dw 20
.db Club \ .dw 20
.db Tonfa \ .dw 20
.db 0
convo12:
.db "Move along, buddy!",0
convo13:
.db "Hey! Are you from the Resistance camp? Come with me!",0
convo14: