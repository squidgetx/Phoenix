;########################
;#    Axiom Helpers     #
;########################

AXM_HEADER      =$C0DE
AXM_END         =$0000

AXM_NOSTUB      =%00000001
AXM_ION         =%00000010
AXM_MOS         =%00000100
AXM_DCS         =%00001000
AXM_APP         =%00010000
AXM_FUSION      =%00100000
AXM_SHELLS      =%00101110
AXM_NONAPP      =%00101111
AXM_ALL         =%00111111

AXM_INLINE      =%00000000
AXM_SUB         =%00000001
AXM_RMOD        =%00000010
AXM_RRMOD       =%00000100
AXM_STORED      =%00001000
AXM_DATA        =%00010000

AXM_0ARGS       =0
AXM_1ARG        =1
AXM_2ARGS       =2
AXM_3ARGS       =3
AXM_4ARGS       =4
AXM_5ARGS       =5
AXM_6ARGS       =6

#define REP_NEXT    .db $7F \ .org $-1
#define REP_NEXT(x) .db $40 \ .db x \ .org $-2
#define ABS_NEXT    .db $49 \ .org $-1

;#######################
;#    Axiom Tokens     #
;#######################

tok_None        =$0000
tok_Load        =$1263
tok_Next        =$1363
tok_Render      =$0063
tok_DrawL       =$1463
tok_DrawR       =$1563
tok_DrawS       =$0163
tok_Print       =$3763
tok_Up          =$1863
tok_Down        =$1963
tok_Left        =$2463
tok_Right       =$1663
tok_New         =$1763
tok_Delete      =$2563

;############################
;#     Axe Subroutines      #
;############################

sub_Mul         =$3F01
sub_Div         =$3F02
sub_Mod         =$3F03
sub_Pix         =$3F04
sub_Rand        =$3F05
sub_FastCpy     =$3F06
sub_OrSprite    =$3F07
sub_XorSprite   =$3F08
sub_OffSprite   =$3F09
sub_DrawInv     =$3F0A
sub_ShiftLeft   =$3F0B
sub_ShiftRight  =$3F0C
sub_ShiftUp     =$3F0D
sub_ShiftDown   =$3F0E
sub_DirectKey   =$3F0F
sub_FreqOut     =$3F10
sub_Sqrt        =$3F11
sub_GetCalc     =$3F12
sub_NewVar      =$3F13
sub_Unarc       =$3F14
sub_Arc         =$3F15
sub_Sin         =$3F16
sub_DispGS      =$3F17
sub_Line        =$3F18
sub_SDiv        =$3F19
sub_TextInt     =$3F1A
sub_4Lvl        =$3F1B
sub_SortD       =$3F1C
sub_EquStr      =$3F1D
sub_88Mul       =$3F1E
sub_Rect        =$3F1F
sub_Circle      =$3F20
sub_RectInv     =$3F21
sub_GetArc      =$3F22
sub_ReadArc     =$3F23
sub_CopyArc     =$3F24
sub_MskSprite   =$3F25
sub_GetByte     =$3F26
sub_SendByte    =$3F27
sub_RotC        =$3F28
sub_RotCC       =$3F29
sub_FlipH       =$3F2A
sub_FlipV       =$3F2B
sub_InData      =$3F2C
sub_Input       =$3F2D
sub_Nib1        =$3F2E
sub_Nib2        =$3F2F
sub_NibSto      =$3F30
sub_Length      =$3F31
sub_GetKeyVar   =$3F32
sub_DrawClr     =$3F33
sub_ToHex       =$3F34
sub_Safety      =$3F35
sub_DispApp     =$3F36
sub_TextApp     =$3F37
sub_Recip	=$3F38
sub_ChkSum	=$3F39
sub_MskSprite2	=$3F3A
sub_CallHL	=$3F3B
sub_DispGSClr	=$3F3C
sub_Disp4Clr	=$3F3D
sub_ReadArcApp	=$3F3E
sub_MulFull     =$3F3F
sub_GetSprite   =$3F40
sub_DrawBmp     =$3F41
sub_ArcTan      =$3F42
sub_Sqrt88      =$3F43
sub_GetKeyPause =$3F44
sub_NthStr      =$3F45
sub_Switch      =$3F46

sub_Axiom1      =$3F60
sub_Axiom2      =$3F61
sub_Axiom3      =$3F62
sub_Axiom4      =$3F63
sub_Axiom5      =$3F64
sub_Axiom6      =$3F65
sub_Axiom7      =$3F66
sub_Axiom8      =$3F67
sub_Axiom9      =$3F68
sub_Axiom10     =$3F69
sub_Axiom11     =$3F6A
sub_Axiom12     =$3F6B
sub_Axiom13     =$3F6C
sub_Axiom14     =$3F6D
sub_Axiom15     =$3F6E
sub_Axiom16     =$3F6F
sub_Axiom17     =$3F70
sub_Axiom18     =$3F71
sub_Axiom19     =$3F72
sub_Axiom20     =$3F73
sub_Axiom21     =$3F74
sub_Axiom22     =$3F75
sub_Axiom23     =$3F76
sub_Axiom24     =$3F77
sub_Axiom25     =$3F78
sub_Axiom26     =$3F79
sub_Axiom27     =$3F7A
sub_Axiom28     =$3F7B
sub_Axiom29     =$3F7C
sub_Axiom30     =$3F7D
sub_Axiom31     =$3F7E
sub_Axiom32     =$3F7F

;############################
;#      Axe Variables       #
;############################

axv_A           =$89B6
axv_B           =$89B8
axv_C           =$89BA
axv_D           =$89BC
axv_E           =$89BE
axv_F           =$89C0
axv_G           =$89C2
axv_H           =$89C4
axv_I           =$89C6
axv_J           =$89C8
axv_K           =$89CA
axv_L           =$89CC
axv_M           =$89CE
axv_N           =$89D0
axv_O           =$89D2
axv_P           =$89D4
axv_Q           =$89D6
axv_R           =$89D8
axv_S           =$89DA
axv_T           =$89DC
axv_U           =$89DE
axv_V           =$89E0
axv_W           =$89E2
axv_X           =$89E4
axv_Y           =$89E6
axv_Z           =$89E8
axv_Theta       =$89EA

axv_R1          =$83A5
axv_R2          =$83A7
axv_R3          =$83A9
axv_R4          =$83AB
axv_R5          =$83AD
axv_R6          =$83AF

axv_Y1          =$83B1
axv_Y1Page      =$83B3
axv_Y2          =$83B4
axv_Y2Page      =$83B6
axv_Y3          =$83B7
axv_Y3Page      =$83B9
axv_Y4          =$83BA
axv_Y4Page      =$83BC
axv_Y5          =$83BD
axv_Y5Page      =$83BF
axv_Y6          =$83C0
axv_Y6Page      =$83C2
axv_Y7          =$83C3
axv_Y7Page      =$83C5
axv_Y8          =$83C6
axv_Y8Page      =$83C8
axv_Y9          =$83C9
axv_Y9Page      =$83CB
axv_Y0          =$83CC
axv_Y0Page      =$83CE

axv_SpriteBuff  =$83CF

axv_RandSeed    =$83D7

axv_X1t         =$83D9
axv_Y1t         =$83DB
axv_X2t         =$83DD
axv_Y2t         =$83DF
axv_X3t         =$83E1
axv_Y3t         =$83E3

;############################
;#    Axe RAM Locations     #
;############################

axr_L1          =$86EC          ;714 bytes
axr_L2          =$8A3A          ;531 bytes
axr_L3          =$9872          ;768 bytes
axr_L4          =$82A5          ;323 bytes
axr_L5          =$8508          ;128 bytes
axr_L6          =$9340          ;768 bytes

;##########################
;#     API Jump Table     #
;##########################

api_MainMenu    =$4083
api_CompileOP1  =$4086
api_TokenHook   =$4089

;###############################
;#     Other API Constants     #
;###############################

api_NoShell     =0
api_Ion         =1
api_MirageOS    =2
api_DoorsCS     =3
api_Application =4