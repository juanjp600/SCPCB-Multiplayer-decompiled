Function se_getfunctionid%(arg0$)
    Select arg0
        Case "breachrole_setroleviewmodelanimation"
            Return $156
        Case "breachrole_createviewmodelforrole"
            Return $155
        Case "redirectsound"
            Return $154
        Case "breachrole_createplayerrole"
            Return $139
        Case "breachrole_getrolename"
            Return $13A
        Case "breachrole_setrolesettings"
            Return $13B
        Case "breachrole_setroleeffects"
            Return $13C
        Case "breachrole_setroleambientsound"
            Return $13D
        Case "breachrole_setroleinstruction"
            Return $13E
        Case "breachrole_setroledeadanimation"
            Return $13F
        Case "breachrole_setrolehitboxscales"
            Return $140
        Case "breachrole_setrolebone"
            Return $141
        Case "breachrole_setroleanimation"
            Return $142
        Case "breachrole_setrolearmedanimation"
            Return $143
        Case "breachrole_markasfriend"
            Return $144
        Case "breachrole_roletakerolespawn"
            Return $145
        Case "breachrole_setrolepositionsoffset"
            Return $146
        Case "breachrole_setroleholdinggrenade"
            Return $147
        Case "breachrole_setroleholdingitem"
            Return $148
        Case "breachrole_setrolehandcuff"
            Return $149
        Case "breachrole_allowroleweaponattaches"
            Return $14A
        Case "breachrole_allowitemsattaches"
            Return $14B
        Case "breachrole_markroleasscp"
            Return $14C
        Case "breachrole_markas035"
            Return $14D
        Case "breachrole_markas049"
            Return $14E
        Case "breachrole_isa035"
            Return $14F
        Case "breachrole_isa049"
            Return $150
        Case "breachrole_isafriend"
            Return $151
        Case "breachrole_getmaxhp"
            Return $152
        Case "breachrole_getrolescale"
            Return $153
        Case "createdecal"
            Return $157
        Case "getitemtemplate"
            Return $136
        Case "getservertimeout"
            Return $135
        Case "camerarange"
            Return $12D
        Case "camerafogrange"
            Return $12E
        Case "gettabmenu"
            Return $12A
        Case "turnentity"
            Return $129
        Case "formattext"
            Return $128
        Case "stringwidth"
            Return $126
        Case "stringheight"
            Return $127
        Case "imagewidth"
            Return $124
        Case "imageheight"
            Return $125
        Case "scaleimage"
            Return $123
        Case "isvalidobject"
            Return $120
        Case "getobjectentity"
            Return $121
        Case "drawblock"
            Return $11F
        Case "browser_create"
            Return $118
        Case "browser_destroy"
            Return $119
        Case "browser_getimage"
            Return $11A
        Case "browser_gettexture"
            Return $11B
        Case "browser_mousedown"
            Return $11C
        Case "browser_mouseup"
            Return $11E
        Case "browser_setmousepos"
            Return $11D
        Case "browser_loadurl"
            Return $122
        Case "tcp_get"
            Return $116
        Case "tcp_close"
            Return $117
        Case "createsprite"
            Return $102
        Case "loadsprite"
            Return $103
        Case "spriteviewmode"
            Return $104
        Case "scalesprite"
            Return $105
        Case "entityfx"
            Return $106
        Case "entityblend"
            Return $107
        Case "showentity"
            Return $108
        Case "hideentity"
            Return $109
        Case "getparent"
            Return $10A
        Case "entityautofade"
            Return $10B
        Case "entitycolor"
            Return $10C
        Case "entityshininess"
            Return $10D
        Case "entityalpha"
            Return $10E
        Case "entitytexture"
            Return $10F
        Case "createtexture"
            Return $110
        Case "loadtexture"
            Return $111
        Case "scaletexture"
            Return $112
        Case "texturewidth"
            Return $113
        Case "textureheight"
            Return $114
        Case "entityparent"
            Return $115
        Case "entityscalex"
            Return $FC
        Case "entityscaley"
            Return $FD
        Case "entityscalez"
            Return $FE
        Case "meshwidth"
            Return $FF
        Case "meshheight"
            Return $100
        Case "meshdepth"
            Return $101
        Case "pointentity"
            Return $FB
        Case "getplayerentity"
            Return $F4
        Case "getplayerhitboxentity"
            Return $F5
        Case "getplayermodelentity"
            Return $F6
        Case "getcurrentspectateplayer"
            Return $F7
        Case "resetentity"
            Return $E5
        Case "entityradius"
            Return $E6
        Case "entitybox"
            Return $E7
        Case "entitycollisiontype"
            Return $E8
        Case "entitypickmode"
            Return $E9
        Case "entitycollided"
            Return $EA
        Case "countcollisions"
            Return $EB
        Case "collisionx"
            Return $EC
        Case "collisiony"
            Return $EC
        Case "collisionz"
            Return $EE
        Case "collisionnx"
            Return $EF
        Case "collisionny"
            Return $F0
        Case "collisionnz"
            Return $F1
        Case "collisionentity"
            Return $F2
        Case "getentitycollisiontype"
            Return $F3
        Case "preparemodelidentifier"
            Return $E4
        Case "getkey"
            Return $E3
        Case "drawuiinputbox"
            Return $E2
        Case "drawuibutton"
            Return $E0
        Case "ismainmenuopen"
            Return $E1
        Case "debuglog"
            Return $01
        Case "initloadingscreens"
            Return $02
        Case "initinfoclues"
            Return $03
        Case "stopallredirecttext"
            Return $04
        Case "setscriptlanguage"
            Return $05
        Case "getscriptpath"
            Return $06
        Case "freefonts"
            Return $07
        Case "loadfonts"
            Return $08
        Case "redirectfont"
            Return $09
        Case "redirectfile"
            Return $0A
        Case "redirecttext"
            Return $0B
        Case "stopredirecttext"
            Return $0C
        Case "disableallworkshopscripts"
            Return $0D
        Case "setintercomtimeout"
            Return $0E
        Case "getintercomtimeout"
            Return $0F
        Case "getinventoryslotitemname"
            Return $10
        Case "setselecteditemfrominventory"
            Return $11
        Case "isvaliditem"
            Return $12
        Case "getselecteditem"
            Return $13
        Case "getitemname"
            Return $14
        Case "getitemtempname"
            Return $15
        Case "getitemstate"
            Return $16
        Case "get427timer"
            Return $17
        Case "getblurtimer"
            Return $18
        Case "getstamina"
            Return $19
        Case "getblinktimer"
            Return $1A
        Case "getcurrentweapon"
            Return $1B
        Case "getcurrentweaponmagazines"
            Return $1C
        Case "getcurrentweaponammo"
            Return $1D
        Case "keyhit"
            Return $1E
        Case "keydown"
            Return $1F
        Case "createsound3d"
            Return $20
        Case "createlocalsound"
            Return $21
        Case "getvolume"
            Return $22
        Case "stop3dsounds"
            Return $2A
        Case "setcamerashake"
            Return $2B
        Case "freefont"
            Return $2C
        Case "freeimage"
            Return $2D
        Case "setfont"
            Return $2E
        Case "color"
            Return $2F
        Case "loadimage"
            Return $30
        Case "loadanimimage"
            Return $31
        Case "loadfont"
            Return $32
        Case "copyimage"
            Return $33
        Case "drawimage"
            Return $34
        Case "resizeimage"
            Return $35
        Case "rotateimage"
            Return $36
        Case "text"
            Return $37
        Case "oval"
            Return $38
        Case "rect"
            Return $39
        Case "mousex"
            Return $3A
        Case "mousey"
            Return $3B
        Case "mousehit1"
            Return $3C
        Case "mousehit2"
            Return $3D
        Case "mousedown1"
            Return $3E
        Case "mousedown2"
            Return $3F
        Case "connect"
            Return $40
        Case "disconnect"
            Return $41
        Case "setplayerroom"
            Return $42
        Case "createpivot"
            Return $43
        Case "loadmesh"
            Return $44
        Case "loadanimmesh"
            Return $45
        Case "getplayercollider"
            Return $46
        Case "getplayercamera"
            Return $47
        Case "cameraclscolor"
            Return $48
        Case "camerafogcolor"
            Return $49
        Case "setambientlight"
            Return $4A
        Case "hidescreenocclusion"
            Return $4B
        Case "showscreenocclusion"
            Return $4C
        Case "getselectedscreen"
            Return $4D
        Case "resetselectedscreen"
            Return $4E
        Case "showsky"
            Return $4F
        Case "hidesky"
            Return $50
        Case "getroomname"
            Return $51
        Case "entityinview"
            Return $52
        Case "entityvisible"
            Return $53
        Case "entityx"
            Return $54
        Case "entityy"
            Return $55
        Case "entityz"
            Return $56
        Case "entitypitch"
            Return $57
        Case "entityyaw"
            Return $58
        Case "entityroll"
            Return $59
        Case "entitypick"
            Return $5A
        Case "positionentity"
            Return $5B
        Case "rotateentity"
            Return $5C
        Case "moveentity"
            Return $5D
        Case "scaleentity"
            Return $5E
        Case "setentitycollision"
            Return $5F
        Case "removeentity"
            Return $60
        Case "setanimtime"
            Return $61
        Case "getdelta"
            Return $62
        Case "getmonitorwidth"
            Return $63
        Case "getmonitorheight"
            Return $64
        Case "sendrawpacket"
            Return $65
        Case "hexstring"
            Return $66
        Case "eof"
            Return $67
        Case "filetype"
            Return $68
        Case "filesize"
            Return $69
        Case "workshopfiletype"
            Return $6A
        Case "workshopfilesize"
            Return $6B
        Case "seekfile"
            Return $6C
        Case "filepos"
            Return $6D
        Case "catcherror"
            Return $6E
        Case "writebytes"
            Return $6F
        Case "readbytes"
            Return $70
        Case "createbank"
            Return $71
        Case "freebank"
            Return $72
        Case "banksize"
            Return $73
        Case "resizebank"
            Return $74
        Case "copybank"
            Return $75
        Case "peekbyte"
            Return $76
        Case "peekshort"
            Return $77
        Case "peekint"
            Return $78
        Case "peekfloat"
            Return $79
        Case "pokebyte"
            Return $7A
        Case "pokeshort"
            Return $7B
        Case "pokeint"
            Return $7C
        Case "pokefloat"
            Return $7D
        Case "movex"
            Return $7E
        Case "movey"
            Return $7F
        Case "movez"
            Return $80
        Case "move"
            Return $81
        Case "pointangle"
            Return $82
        Case "pointpitch"
            Return $83
        Case "pointat"
            Return $84
        Case "closefile"
            Return $85
        Case "readline"
            Return $86
        Case "readint"
            Return $87
        Case "readfloat"
            Return $88
        Case "readshort"
            Return $89
        Case "readbyte"
            Return $8A
        Case "writeline"
            Return $8B
        Case "writeint"
            Return $8C
        Case "writefloat"
            Return $8D
        Case "writeshort"
            Return $8E
        Case "writebyte"
            Return $8F
        Case "openfile"
            Return $90
        Case "readfile"
            Return $91
        Case "writefile"
            Return $92
        Case "openworkshopfile"
            Return $93
        Case "readworkshopfile"
            Return $94
        Case "writeworkshopfile"
            Return $95
        Case "getversion"
            Return $96
        Case "millisecs"
            Return $97
        Case "getping"
            Return $98
        Case "getname"
            Return $99
        Case "setgamemessage"
            Return $9A
        Case "sendconsolecommand"
            Return $9B
        Case "sendmessage"
            Return $9C
        Case "plugin_remove"
            Return $9D
        Case "plugin_call"
            Return $9E
        Case "plugin_poke"
            Return $9F
        Case "plugin_load"
            Return $A0
        Case "int"
            Return $A1
        Case "float"
            Return $A2
        Case "str"
            Return $A3
        Case "floor"
            Return $A4
        Case "ceil"
            Return $A5
        Case "sgn"
            Return $A6
        Case "abs"
            Return $A7
        Case "sqr"
            Return $A8
        Case "sin"
            Return $A9
        Case "cos"
            Return $AA
        Case "tan"
            Return $AB
        Case "asin"
            Return $AC
        Case "acos"
            Return $AD
        Case "atan"
            Return $AE
        Case "atan2"
            Return $AF
        Case "exp"
            Return $B0
        Case "log"
            Return $B1
        Case "log10"
            Return $B2
        Case "rnd"
            Return $B3
        Case "rand"
            Return $B4
        Case "num"
            Return $B5
        Case "left"
            Return $B6
        Case "right"
            Return $B7
        Case "mid"
            Return $B8
        Case "replace"
            Return $B9
        Case "instr"
            Return $BA
        Case "lower"
            Return $BB
        Case "upper"
            Return $BC
        Case "trim"
            Return $BD
        Case "chr"
            Return $BE
        Case "asc"
            Return $BF
        Case "hex"
            Return $C0
        Case "bin"
            Return $C1
        Case "repeat"
            Return $C2
        Case "create"
            Return $C3
        Case "push"
            Return $C4
        Case "pop"
            Return $C5
        Case "delete"
            Return $C6
        Case "sort"
            Return $C7
        Case "from_string"
            Return $C8
        Case "getfov"
            Return $C9
        Case "handleimage"
            Return $CA
        Case "caninteract"
            Return $CB
        Case "callglobalfunction"
            Return $CC
        Case "callfunction"
            Return $CD
        Case "ismenuopen"
            Return $CE
        Case "isinventoryopen"
            Return $CF
        Case "isotherinventoryopen"
            Return $D0
        Case "lockmouse"
            Return $D1
        Case "getoptionsmenu"
            Return $D2
        Case "getachievementsmenu"
            Return $D3
        Case "showpointer"
            Return $D4
        Case "hidepointer"
            Return $D5
        Case "iskeypadopen"
            Return $D6
        Case "isconsoleopen"
            Return $D7
        Case "iscoffeemachineopen"
            Return $D8
        Case "getinivalue"
            Return $D9
        Case "putinivalue"
            Return $DA
        Case "updateinifile"
            Return $DB
        Case "createtimer"
            Return $DC
        Case "removetimer"
            Return $DD
        Case "lerp"
            Return $DE
        Case "lerpangle"
            Return $DF
        Case "deltayaw"
            Return $F8
        Case "deltapitch"
            Return $F9
        Case "entitydistance"
            Return $FA
        Case "setmousehit1"
            Return $12B
        Case "setmousedown1"
            Return $12C
        Case "createcube"
            Return $12F
        Case "createsphere"
            Return $132
        Case "createcylinder"
            Return $131
        Case "createcone"
            Return $130
        Case "createevent"
            Return $133
        Case "setradio"
            Return $134
        Case "createitemtemplate"
            Return $137
        Case "changeroommesh"
            Return $138
    End Select
    Return $00
End Function