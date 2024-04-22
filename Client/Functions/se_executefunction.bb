Function se_executefunction%(arg0%, arg1.se_funcptr)
    Local local0$
    Local local1%
    Local local3.decals
    Local local4$
    Local local5.rooms
    Local local6.itemtemplates
    Local local7.events
    Local local8.steambrowser
    Local local9%
    Local local10$
    Local local11%
    Local local12%
    Local local13.bs
    Local local14$
    Local local15%
    Local local17$
    Local local18$
    Local local19$
    Local local20$
    Local local21.se_script
    Local local22.scriptsthread
    Local local23.workshopthread
    Local local24$
    Local local25$
    Local local26%
    Local local27%
    Local local28%
    Local local29#
    Local local30#
    Local local31#
    Local local32#
    Local local33#
    Local local34.sound
    Local local35%
    Local local36%
    Local local37%
    Local local38.snd3d
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local43%
    Local local44%
    Local local45%
    Local local46%
    Local local47%
    Local local48%
    Local local49%
    Local local50%
    Local local51%
    Local local52%
    Local local53#
    Local local54%
    Local local55%
    Local local56$
    Local local57%
    Local local58%
    Local local59%
    Local local60$
    Local local61%
    Local local62$
    Local local63$
    Local local64.rooms
    Local local65%
    Local local66#
    Local local67#
    Local local68#
    Local local69%
    Local local70%
    Local local71$
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80%
    Local local81#
    Local local82#
    Local local83#
    Local local84#
    Local local85#
    Local local86%
    Local local87%
    Local local88$
    Local local89%
    Local local90%
    Local local91%
    Local local92$
    Local local93%
    Local local94%
    Local local95%
    Local local96%
    local1 = $00
    se_resetparam()
    se_getparams()
    flipped = $00
    Select arg0
        Case $156
            multiplayer_breach_setroleviewmodelanimation(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tofloatarg($04, 0.0))
        Case $155
            multiplayer_breach_createviewmodelforrole(se_tointarg($00, $00), se_tostringarg($01, ""), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tofloatarg($04, 0.0), se_tofloatarg($05, 0.0))
        Case $154
            redirectsound(se_tostringarg($00, ""), se_tostringarg($01, ""), se_tointarg($02, $00))
        Case $139
            multiplayer_breach_createplayerrole(se_tostringarg($00, ""), se_tointarg($01, $00), se_tofloatarg($02, 0.0), se_tostringarg($03, ""), se_tointarg($04, $00), se_tointarg($05, $00), se_tointarg($06, $00), se_tointarg($07, $00))
        Case $13A
            local0 = gettypename(se_tointarg($00, $00))
            local1 = $03
        Case $13B
            multiplayer_breach_setrolesettings(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tofloatarg($04, 0.0), se_tointarg($05, $00), se_tostringarg($06, ""), se_tointarg($07, $00), se_tointarg($08, $00))
        Case $13C
            multiplayer_breach_setroleeffects(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tointarg($04, $00), se_tointarg($05, $00), se_tointarg($06, $00), se_tointarg($07, $00), se_tointarg($08, $00), se_tointarg($09, $00), se_tointarg($0A, $00))
        Case $13D
            multiplayer_breach_setroleambientsound(se_tointarg($00, $00), se_tointarg($01, $00), se_tostringarg($02, ""))
        Case $13E
            multiplayer_breach_setroleinstruction(se_tointarg($00, $00), se_tostringarg($01, ""))
        Case $13F
            multiplayer_breach_setroledeadanimation(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00))
        Case $140
            multiplayer_breach_setrolehitboxscales(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0))
        Case $141
            multiplayer_breach_setrolebone(se_tointarg($00, $00), se_tointarg($01, $00), se_tostringarg($02, ""))
        Case $142
            multiplayer_breach_setroleanimation(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tofloatarg($04, 0.0))
        Case $143
            multiplayer_breach_setrolearmedanimation(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tofloatarg($04, 0.0))
        Case $144
            multiplayer_breach_markasfriend(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00))
        Case $145
            multiplayer_breach_roletakerolespawn(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $146
            multiplayer_breach_setrolepositionsoffset(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0))
        Case $147
            multiplayer_breach_setroleholdinggrenade(se_tointarg($00, $00), se_tostringarg($01, ""), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0))
        Case $148
            multiplayer_breach_setroleholdingitem(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $149
            multiplayer_breach_setrolehandcuff(se_tointarg($00, $00), se_tostringarg($01, ""), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tofloatarg($04, 0.0), se_tostringarg($05, ""), se_tofloatarg($06, 0.0), se_tofloatarg($07, 0.0), se_tofloatarg($08, 0.0))
        Case $14A
            multiplayer_breach_allowroleweaponattaches(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $14B
            multiplayer_breach_allowitemsattaches(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $14C
            multiplayer_breach_markroleasscp(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $14D
            multiplayer_breach_markas035(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $14E
            multiplayer_breach_markas049(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $14F
            local0 = (Str multiplayer_breach_isa035(se_tointarg($00, $00)))
            local1 = $01
        Case $150
            local0 = (Str multiplayer_breach_isa049(se_tointarg($00, $00)))
            local1 = $01
        Case $151
            local0 = (Str multiplayer_isafriend(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $01
        Case $152
            local0 = (Str multiplayer_breach_getmaxhp(se_tointarg($00, $00)))
            local1 = $01
        Case $153
            local0 = (Str multiplayer_breach_getrolescale(se_tointarg($00, $00)))
            local1 = $02
        Case $157
            local3 = createdecal(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tofloatarg($04, 0.0), se_tofloatarg($05, 0.0), se_tofloatarg($06, 0.0), se_tofloatarg($07, 0.0), se_tofloatarg($08, 0.0))
            If (local3 <> Null) Then
                multiplayer_writedecal(local3, $01, $01)
            EndIf
        Case $158
            multiplayer_updateplayermodel(se_tointarg($00, $00))
        Case $138
            local4 = se_tostringarg($00, "")
            For local5 = Each rooms
                If (local5\Field7\Field11 = local4) Then
                    changermesh(local5, se_tostringarg($01, ""))
                EndIf
            Next
        Case $137
            local6 = createitemtemplate(se_tostringarg($00, ""), se_tostringarg($01, ""), se_tostringarg($02, ""), se_tostringarg($03, ""), se_tostringarg($04, ""), se_tofloatarg($05, 0.0), "", "", $00, $09, $00)
            local6\Field3 = se_tointarg($06, $00)
            local0 = (Str local6\Field0)
            local1 = $01
        Case $136
            local0 = (Str m_item[se_tointarg($00, $00)]\Field3\Field0)
            local1 = $01
        Case $135
            local0 = (Str ((millisecs() - networkserver\Field4) - networkserver\Field3))
            local1 = $01
        Case $F7
            local0 = (Str spectate\Field1)
            local1 = $01
        Case $134
            myplayer\Field67 = se_getparamint()
        Case $133
            local7 = createevent(se_tostringarg($00, ""), se_tostringarg($01, ""), se_tointarg($02, $00), se_tofloatarg($03, 0.0))
            If (local7 <> Null) Then
                local0 = (Str local7\Field15)
            EndIf
            local1 = $01
        Case $12F
            local0 = (Str createcube($00))
            local1 = $01
        Case $132
            local0 = (Str createsphere($08, $00))
            local1 = $01
        Case $131
            local0 = (Str createcylinder($08, $01, $00))
            local1 = $01
        Case $130
            local0 = (Str createcone($08, $01, $00))
            local1 = $01
        Case $12D
            camerarange(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $12E
            camerafogrange(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $12B
            mousehit1 = se_tointarg($00, $00)
        Case $12C
            mousedown1 = se_tointarg($00, $00)
        Case $12A
            local0 = (Str tab_menu_state)
            local1 = $01
        Case $129
            turnentity(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tointarg($04, $00))
        Case $128
            formattextdefault(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0), se_tostringarg($02, ""), se_tointarg($03, $00), se_tointarg($04, $00), se_tofloatarg($05, 0.0), se_tointarg($06, $00))
        Case $126
            local0 = (Str stringwidth(se_tostringarg($00, "")))
            local1 = $01
        Case $127
            local0 = (Str stringheight(se_tostringarg($00, "")))
            local1 = $01
        Case $124
            local0 = (Str imagewidth(se_tointarg($00, $00)))
            local1 = $01
        Case $125
            local0 = (Str imageheight(se_tointarg($00, $00)))
            local1 = $01
        Case $123
            scaleimage(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $120
            local0 = (Str (multiplayer_object[se_tointarg($00, $00)] <> Null))
            local1 = $01
        Case $121
            local0 = (Str multiplayer_object[se_tointarg($00, $00)]\Field1)
            local1 = $01
        Case $122
            steambrowser_loadurl((Object.steambrowser se_tointarg($00, $00)), se_tostringarg($01, ""), se_tostringarg($02, ""))
        Case $118
            local8 = steambrowser_create(se_tointarg($00, $00), se_tointarg($01, $00), se_tostringarg($02, ""), "SteamBrowser", "")
            local0 = (Str (Handle local8))
            local1 = $01
        Case $119
            steambrowser_destroy((Object.steambrowser se_tointarg($00, $00)))
        Case $11A
            local0 = (Str steambrowser_getimagehandle((Object.steambrowser se_tointarg($00, $00))))
            local1 = $01
        Case $11B
            local0 = (Str steambrowser_gettexturehandle((Object.steambrowser se_tointarg($00, $00))))
            local1 = $01
        Case $11C
            local8 = (Object.steambrowser se_tointarg($00, $00))
            bs_isteamhtmlsurface_mousedown(bs_steamhtmlsurface(), local8\Field0, $00)
        Case $11E
            local8 = (Object.steambrowser se_tointarg($00, $00))
            bs_isteamhtmlsurface_mouseup(bs_steamhtmlsurface(), local8\Field0, $00)
        Case $11D
            local8 = (Object.steambrowser se_tointarg($00, $00))
            bs_isteamhtmlsurface_mousemove(bs_steamhtmlsurface(), local8\Field0, se_tointarg($01, $00), se_tointarg($02, $00))
        Case $116
            local0 = (Str downloadfile(se_tostringarg($00, "")))
            local1 = $01
        Case $117
            closetcpstream(se_tointarg($00, $00))
        Case $102
            local0 = (Str createsprite($00))
            local1 = $01
        Case $103
            local0 = (Str loadsprite(se_tostringarg($00, ""), se_tointarg($01, $00), $00))
            local1 = $01
        Case $104
            spriteviewmode(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $105
            scalesprite(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $106
            entityfx(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $107
            entityblend(se_tointarg($00, $00), se_tointarg($01, $00))
        Case $108
            showentity(se_tointarg($00, $00))
        Case $109
            hideentity(se_tointarg($00, $00))
        Case $10A
            local0 = (Str getparent(se_tointarg($00, $00)))
            local1 = $01
        Case $10B
            entityautofade(se_tointarg($00, $00), se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0))
        Case $10C
            entitycolor(se_tointarg($00, $00), (Float se_tointarg($01, $00)), (Float se_tointarg($02, $00)), (Float se_tointarg($03, $00)))
        Case $10D
            entityshininess(se_tointarg($00, $00), se_tofloatarg($01, 0.0))
        Case $10E
            entityalpha(se_tointarg($00, $00), se_tofloatarg($01, 0.0))
        Case $10F
            entitytexture(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00))
        Case $110
            local0 = (Str createtexture(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00)))
            local1 = $01
        Case $111
            local0 = (Str loadtexture(se_tostringarg($00, ""), se_tointarg($01, $00)))
            local1 = $01
        Case $112
            scaletexture(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0))
        Case $113
            local0 = (Str texturewidth(se_tointarg($00, $00)))
            local1 = $01
        Case $114
            local0 = (Str textureheight(se_tointarg($00, $00)))
            local1 = $01
        Case $115
            entityparent(se_tointarg($00, $00), se_tointarg($01, $00), $01)
        Case $FC
            local0 = (Str entityscalex2(se_tointarg($00, $00)))
            local1 = $02
        Case $FD
            local0 = (Str entityscaley2(se_tointarg($00, $00)))
            local1 = $02
        Case $FE
            local0 = (Str entityscalez2(se_tointarg($00, $00)))
            local1 = $02
        Case $FF
            local0 = (Str meshwidth(se_tointarg($00, $00)))
            local1 = $02
        Case $100
            local0 = (Str meshheight(se_tointarg($00, $00)))
            local1 = $02
        Case $101
            local0 = (Str meshdepth(se_tointarg($00, $00)))
            local1 = $02
        Case $FB
            pointentity(se_tointarg($00, $00), se_tointarg($01, $00), 0.0)
        Case $FA
            local0 = (Str entitydistance(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $F8
            local0 = (Str deltayaw(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $F9
            local0 = (Str deltapitch(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case local9
            local0 = (Str (player[se_tointarg($00, $00)] <> Null))
            local1 = $01
        Case $F4
        Case $F5
        Case $F6
        Case $E5
            resetentity(se_tointarg($00, $00))
        Case $E6
            entityradius(se_tointarg($00, $00), se_tofloatarg($01, 0.0), 0.0)
        Case $E7
            entitybox(se_tointarg($00, $00), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0), se_tofloatarg($03, 0.0), se_tofloatarg($04, 0.0), se_tofloatarg($05, 0.0), se_tofloatarg($06, 0.0))
        Case $E8
            entitytype(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00))
        Case $E9
            entitypickmode(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00))
        Case $EA
            local0 = (Str entitycollided(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $01
        Case $EB
            local0 = (Str countcollisions(se_tointarg($00, $00)))
            local1 = $01
        Case $EC
            local0 = (Str collisionx(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $ED
            local0 = (Str collisiony(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $EE
            local0 = (Str collisionz(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $EF
            local0 = (Str collisionnx(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $F0
            local0 = (Str collisionny(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $F1
            local0 = (Str collisionnz(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $02
        Case $F2
            local0 = (Str collisionentity(se_tointarg($00, $00), se_tointarg($01, $00)))
            local1 = $01
        Case $F3
            local0 = (Str getentitytype(se_tointarg($00, $00)))
            local1 = $01
        Case $E4
            preparemodelidentifier(se_tointarg($00, $00), se_tostringarg($01, ""))
        Case $E3
            local0 = (Str getkey())
            local1 = $01
        Case $E2
            local0 = inputbox(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tostringarg($04, ""), se_tointarg($05, $00), $00, -1.0)
            local1 = $03
        Case $E0
            local0 = (Str drawbutton(se_tointarg($00, $00), se_tointarg($01, $00), se_tointarg($02, $00), se_tointarg($03, $00), se_tostringarg($04, ""), se_tointarg($05, $00), se_tointarg($06, $00), $01, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $01))
            local1 = $01
        Case $E1
            local0 = (Str mainmenuopen)
            local1 = $01
        Case $DE
            If (se_tointarg($03, $00) = $00) Then
                local0 = (Str curvevalue(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0)))
            Else
                local0 = (Str tovalue(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0)))
            EndIf
            local1 = $02
        Case $DF
            If (se_tointarg($03, $00) = $00) Then
                local0 = (Str curveangle(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0)))
            Else
                local0 = (Str toangle(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0), se_tofloatarg($02, 0.0)))
            EndIf
            local1 = $02
        Case $DD
            removetimer((Object.timers se_getparamint()))
        Case $DC
            local10 = se_getparamstring()
            local11 = se_getparamint()
            local12 = se_getparamint()
            local13 = createbytestream($174)
            For local15 = $03 To (se_arguments_number - $01) Step $01
                If (se_argtype(local15) <> $00) Then
                    Select se_argtype(local15)
                        Case $01
                            local14 = (local14 + "i")
                            bytestreamwriteint(local13, se_tointarg(local15, $00))
                        Case $02
                            local14 = (local14 + "f")
                            bytestreamwritefloat(local13, se_tofloatarg(local15, 0.0))
                        Case $03
                            local14 = (local14 + "s")
                            bytestreamwritestring(local13, se_tostringarg(local15, ""))
                    End Select
                EndIf
            Next
            local0 = (Str settimer(arg1\Field1, local10, local11, local12, local14, local13))
            local1 = $01
        Case $D9
            local17 = se_getparamstring()
            local18 = se_getparamstring()
            local19 = se_getparamstring()
            local20 = se_getparamstring()
            local1 = $03
            local0 = getinistring(local17, local18, local19, local20)
        Case $DA
            local17 = se_getparamstring()
            local18 = se_getparamstring()
            local19 = se_getparamstring()
            local20 = se_getparamstring()
            putinivalue(local17, local18, local19, local20)
        Case $DB
            updateinifile(se_getparamstring())
        Case $CC
            local21 = Null
            For local22 = Each scriptsthread
                If (local22\Field0 <> Null) Then
                    If (lower(local22\Field1) = lower(se_tostringarg($00, ""))) Then
                        local21 = local22\Field0
                        Exit
                    EndIf
                EndIf
            Next
            If (local21 = Null) Then
                For local23 = Each workshopthread
                    If (local23\Field2 <> Null) Then
                        If (lower(local23\Field0) = lower(se_tostringarg($00, ""))) Then
                            local21 = local23\Field2
                            Exit
                        EndIf
                    EndIf
                Next
            EndIf
            For local15 = $02 To se_arguments_number Step $01
                If (se_argtype(local15) <> $00) Then
                    public_addparam(se_tostringarg(local15, ""), se_argtype(local15))
                EndIf
            Next
            public_update_by_func(se_findfunc(local21, lower(se_tostringarg($01, ""))), $01)
            public_clear()
            local0 = se_getreturnvalue()
            local1 = se_return_value\Field0
        Case $CD
            For local15 = $01 To se_arguments_number Step $01
                If (se_argtype(local15) <> $00) Then
                    public_addparam(se_tostringarg(local15, ""), se_argtype(local15))
                EndIf
            Next
            public_update_by_func(se_findfunc(arg1\Field1, lower(se_tostringarg($00, ""))), $01)
            public_clear()
            local0 = se_getreturnvalue()
            local1 = se_return_value\Field0
        Case $D6
            local0 = (Str (selecteddoor <> Null))
            local1 = $01
        Case $D7
            local0 = (Str consoleopen)
            local1 = $01
        Case $D8
            local0 = (Str using294)
            local1 = $01
        Case $CE
            local0 = (Str menuopen)
            local1 = $01
        Case $CF
            local0 = (Str invopen)
            local1 = $01
        Case $D0
            local0 = (Str (otheropen <> Null))
            local1 = $01
        Case $D1
            lockmouse = se_getparamint()
        Case $D2
            local0 = (Str optionsmenu)
            local1 = $01
        Case $D3
            local0 = (Str achievementsmenu)
            local1 = $01
        Case $D4
            showpointer()
        Case $D5
            hidepointer()
        Case $01
            debuglog(se_getparamstring())
        Case $02
            initloadingscreens(se_getparamstring())
        Case $03
            initinfoclues(se_getparamstring())
        Case $04
            ws_clearredirecttext()
        Case $05
            If (arg1 <> Null) Then
                local1 = $03
                For local23 = Each workshopthread
                    If (local23\Field2 = arg1\Field1) Then
                        local23\Field3 = se_getparamstring()
                        Exit
                    EndIf
                Next
            EndIf
        Case $06
            If (arg1 <> Null) Then
                local1 = $03
                For local23 = Each workshopthread
                    If (local23\Field2 = arg1\Field1) Then
                        local0 = local23\Field1
                        Exit
                    EndIf
                Next
            EndIf
        Case $07
            freeallfonts(se_getparamint(), $00)
        Case $08
            loadallfonts(se_getparamint())
        Case $09
            local24 = se_getparamstring()
            local25 = se_getparamstring()
            local0 = (Str ws_redirectfont(local24, local25))
            local1 = $01
        Case $0A
            local24 = se_getparamstring()
            local25 = se_getparamstring()
            local0 = (Str ws_redirectfile(local24, local25))
            local1 = $01
        Case $0B
            local24 = se_getparamstring()
            local25 = se_getparamstring()
            local0 = (Str ws_redirecttext(local24, local25))
            local1 = $01
        Case $0C
            local24 = se_getparamstring()
            local0 = (Str ws_stopredirecttext(local24))
            local1 = $01
        Case $0D
            ws_disableall()
        Case $0E
        Case $0F
        Case $10
            local26 = se_getparamint()
            local0 = "Null"
            local1 = $03
            If (inventory(local26) <> Null) Then
                local0 = inventory(local26)\Field3\Field1
                local1 = $03
            EndIf
        Case $11
            local26 = se_getparamint()
            If (inventory(local26) <> Null) Then
                selecteditem = inventory(local26)
            EndIf
        Case $12
            local27 = se_getparamint()
            local1 = $01
            If (((local27 > $00) And (local27 < $3E8)) <> 0) Then
                local0 = (Str (m_item[local27] <> Null))
            EndIf
        Case $13
            local1 = $01
            If (selecteditem <> Null) Then
                local0 = (Str selecteditem\Field18)
            Else
                local0 = "0"
            EndIf
        Case $14
            local27 = se_getparamint()
            local1 = $03
            If (((local27 > $00) And (local27 < $3E8)) <> 0) Then
                local0 = m_item[local27]\Field3\Field1
            EndIf
        Case $15
            local27 = se_getparamint()
            local1 = $03
            If (((local27 > $00) And (local27 < $3E8)) <> 0) Then
                local0 = m_item[local27]\Field3\Field2
            EndIf
        Case $16
            local27 = se_getparamint()
            local1 = $02
            If (((local27 > $00) And (local27 < $3E8)) <> 0) Then
                local0 = (Str m_item[local27]\Field13)
            EndIf
        Case $17
            local0 = (Str i_427\Field1)
            local1 = $02
        Case $18
            local0 = (Str blurtimer)
            local1 = $02
        Case $19
            local0 = (Str stamina)
            local1 = $02
        Case $1A
            local0 = (Str blinktimer)
            local1 = $02
        Case $1B
            If (eqquipedgun <> Null) Then
                local0 = (Str eqquipedgun\Field0)
                local1 = $01
            EndIf
        Case $1C
            If (eqquipedgun <> Null) Then
                local0 = (Str eqquipedgun\Field18)
                local1 = $01
            EndIf
        Case $1D
            If (eqquipedgun <> Null) Then
                local0 = (Str eqquipedgun\Field1)
                local1 = $01
            EndIf
        Case $1E
            local0 = (Str keyhit(se_getparamint()))
            local1 = $01
        Case $1F
            local0 = (Str keydown(se_getparamint()))
            local1 = $01
        Case $20
            se_flipparams($06)
            local28 = $00
            local29 = (Float se_getflippedparamstring())
            local30 = (Float se_getflippedparamstring())
            local31 = (Float se_getflippedparamstring())
            local32 = (Float se_getflippedparamstring())
            local33 = (Float se_getflippedparamstring())
            local17 = se_getflippedparamstring()
            For local34 = Each sound
                If (local34\Field1 = local17) Then
                    local28 = play3dsoundentity((Handle local34), camera, local35, (Float local36), (Float local37), "")
                    local17 = ""
                    Exit
                EndIf
            Next
            If (local17 <> "") Then
                local28 = play3dsoundentity($00, camera, local35, (Float local36), (Float local37), local17)
            EndIf
            local0 = (Str local28)
            local1 = $01
        Case $21
            local28 = playsound_strict(loadtempsound(se_tostringarg($00, "")))
            channelvolume(local28, se_tofloatarg($01, 0.0))
            local0 = (Str local28)
            local1 = $01
        Case $22
            local0 = (Str sfxvolume)
            local1 = $02
        Case $2A
            For local38 = Each snd3d
                If (local38\Field0 = $00) Then
                    stopchannel(local38\Field2)
                    If (local38\Field1 <> $00) Then
                        freesound(local38\Field1)
                    EndIf
                    If (local38\Field6 <> 0) Then
                        freeentity(local38\Field5)
                    EndIf
                    Delete local38
                Else
                    fsound_stopsound(local38\Field2)
                    fsound_stream_close(local38\Field1)
                    Delete local38
                EndIf
            Next
        Case $2B
            camerashake = se_getparamfloat()
        Case $2C
            freefont(se_getparamint())
        Case $2D
            freeimage(se_getparamint())
        Case $2E
            selectedfont_ = se_getparamint()
            setfont(selectedfont_)
        Case $2F
            local39 = se_getparamint()
            local40 = se_getparamint()
            local41 = se_getparamint()
            color(local39, local40, local41)
        Case $30
            local0 = (Str loadimage(se_getparamstring()))
            local1 = $01
        Case $31
            local42 = se_getparamstring()
            local43 = se_getparamint()
            local44 = se_getparamint()
            local45 = se_getparamint()
            local46 = se_getparamint()
            local0 = (Str loadanimimage(se_getparamstring(), local43, local44, local45, local46))
            local1 = $01
        Case $32
            local42 = se_getparamstring()
            local47 = se_getparamint()
            local48 = se_getparamint()
            local49 = se_getparamint()
            local50 = se_getparamint()
            local0 = (Str loadfont(local42, local47, local48, local49, local50))
            local1 = $01
        Case $33
            local0 = (Str copyimage(se_getparamint()))
            local1 = $01
        Case $34
            local51 = se_getparamint()
            local39 = se_getparamint()
            local40 = se_getparamint()
            local52 = se_getparamint()
            drawimage(local51, local39, local40, local52)
        Case $11F
            local51 = se_getparamint()
            local39 = se_getparamint()
            local40 = se_getparamint()
            local52 = se_getparamint()
            drawblock(local51, local39, local40, local52)
        Case $35
            local51 = se_getparamint()
            local43 = se_getparamint()
            local44 = se_getparamint()
            resizeimage(local51, (Float local43), (Float local44))
        Case $36
            local51 = se_getparamint()
            local53 = se_getparamfloat()
            rotateimage(local51, local53)
        Case $37
            local54 = se_getparamint()
            local55 = se_getparamint()
            local56 = se_getparamstring()
            local57 = se_getparamint()
            local58 = se_getparamint()
            text(local54, local55, local56, local57, local58)
        Case $38
            local54 = se_getparamint()
            local55 = se_getparamint()
            local43 = (Int se_getparamstring())
            local44 = se_getparamint()
            local59 = se_getparamint()
            oval(local54, local55, local43, local44, local59)
        Case $39
            local54 = se_getparamint()
            local55 = se_getparamint()
            local43 = (Int se_getparamstring())
            local44 = se_getparamint()
            local59 = se_getparamint()
            rect(local54, local55, local43, local44, local59)
        Case $3A
            local0 = (Str mousex())
            local1 = $01
        Case $3B
            local0 = (Str mousey())
            local1 = $01
        Case $3C
            local0 = (Str mousehit1)
            local1 = $01
        Case $3D
            local0 = (Str mousehit2)
            local1 = $01
        Case $3E
            local0 = (Str mousedown1)
            local1 = $01
        Case $3F
            local0 = (Str mousedown($02))
            local1 = $01
        Case $40
            local60 = se_getparamstring()
            local61 = se_getparamint()
            local62 = se_getparamstring()
            disconnectserver("", $01)
            multiplayer_connectto(local60, local61, local62, $00, $1388)
        Case $41
            disconnectserver(se_getparamstring(), $01)
        Case $42
            local63 = se_getparamstring()
            For local64 = Each rooms
                If (local64\Field7\Field11 = local63) Then
                    local0 = (Str local64\Field65)
                    local1 = $01
                    playerroom = local64
                    Exit
                EndIf
            Next
        Case $43
            local0 = (Str createpivot($00))
            local1 = $01
        Case $44
            local0 = (Str loadmesh(se_getparamstring(), $00))
            local1 = $01
        Case $45
            local0 = (Str loadanimmesh(se_getparamstring(), $00))
            local1 = $01
        Case $46
            local0 = (Str collider)
            local1 = $01
        Case $47
            local0 = (Str camera)
            local1 = $01
        Case $48
            local39 = se_getparamint()
            local40 = se_getparamint()
            local41 = se_getparamint()
            cameraclscolor(camera, (Float local39), (Float local40), (Float local41))
        Case $49
            local39 = se_getparamint()
            local40 = se_getparamint()
            local41 = se_getparamint()
            camerafogcolor(camera, (Float local39), (Float local40), (Float local41))
        Case $4A
            local39 = se_getparamint()
            local40 = se_getparamint()
            local41 = se_getparamint()
            ambientlight((Float local39), (Float local40), (Float local41))
        Case $4B
            hideentity(fog)
        Case $4C
            showentity(fog)
        Case $4D
            local0 = (Str (selectedscreen <> Null))
            local1 = $01
        Case $4E
            selectedscreen = Null
        Case $4F
            If (sky <> $00) Then
                showentity(sky)
            EndIf
        Case $50
            If (sky <> $00) Then
                hideentity(sky)
            EndIf
        Case $51
            If (playerroom <> Null) Then
                local0 = playerroom\Field7\Field11
            EndIf
            local1 = $03
        Case $52
            local65 = se_getparamint()
            local0 = (Str entityinview(local65, se_getparamint()))
            local1 = $01
        Case $53
            local65 = se_getparamint()
            local0 = (Str entityvisible(local65, se_getparamint()))
            local1 = $01
        Case $54
            local0 = (Str entityx(se_getparamint(), $00))
            local1 = $02
        Case $55
            local0 = (Str entityy(se_getparamint(), $00))
            local1 = $02
        Case $56
            local0 = (Str entityz(se_getparamint(), $00))
            local1 = $02
        Case $57
            local0 = (Str entitypitch(se_getparamint(), $00))
            local1 = $02
        Case $58
            local0 = (Str entityyaw(se_getparamint(), $00))
            local1 = $02
        Case $59
            local0 = (Str entityroll(se_getparamint(), $00))
            local1 = $02
        Case $5A
            local65 = se_getparamint()
            local0 = (Str entitypick(local65, se_getparamfloat()))
            local1 = $01
        Case $5B
            local65 = se_getparamint()
            local66 = se_getparamfloat()
            local67 = se_getparamfloat()
            local68 = se_getparamfloat()
            positionentity(local65, local66, local67, local68, se_getparamint())
        Case $5C
            local65 = se_getparamint()
            local66 = se_getparamfloat()
            local67 = se_getparamfloat()
            local68 = se_getparamfloat()
            rotateentity(local65, local66, local67, local68, se_getparamint())
        Case $5D
            If (se_tointarg($04, $00) = $00) Then
                local65 = se_getparamint()
                local66 = se_getparamfloat()
                local67 = se_getparamfloat()
                local68 = se_getparamfloat()
                moveentity(local65, local66, local67, local68)
            Else
                local65 = se_getparamint()
                local66 = se_getparamfloat()
                local67 = se_getparamfloat()
                local68 = se_getparamfloat()
                translateentity(local65, local66, local67, local68, $00)
            EndIf
        Case $5E
            local65 = se_getparamint()
            local66 = se_getparamfloat()
            scaleentity(local65, local66, local66, local66, $00)
        Case $5F
            local65 = se_getparamint()
            entitytype(local65, (se_getparamint() Shl $00), $00)
        Case $60
            freeentity(se_getparamint())
        Case $61
            local65 = se_getparamint()
            local66 = se_getparamfloat()
            setanimtime(local65, local66, $00)
        Case $62
            local0 = (Str fpsfactor)
            local1 = $02
        Case $63
            local0 = (Str graphicwidth)
            local1 = $01
        Case $64
            local0 = (Str graphicheight)
            local1 = $01
        Case $65
            local69 = se_getparamint()
            udp_writebyte($72)
            udp_writebyte(networkserver\Field28)
            udp_writebytes(local69, $00, banksize(local69))
            udp_sendmessage($00)
        Case $66
            local71 = se_getparamstring()
            For local15 = $01 To len(local71) Step $01
                local70 = (local70 + (asc(mid(local71, local15, $01)) Shl ((local15 - $01) Shl $03)))
            Next
            local0 = (Str local70)
            local1 = $01
        Case $67
            local0 = (Str eof((Int se_getparamstring())))
            local1 = $01
        Case $68
            local0 = (Str filetype(("multiplayer\" + se_getparamstring())))
            local1 = $01
        Case $69
            local0 = (Str filesize(("multiplayer\" + se_getparamstring())))
            local1 = $01
        Case $6A
            local0 = (Str filetype(("workshop\" + se_getparamstring())))
            local1 = $01
        Case $6B
            local0 = (Str filesize(("workshop\" + se_getparamstring())))
            local1 = $01
        Case $6C
            local72 = se_getparamint()
            local73 = se_getparamint()
            seekfile(local72, local73)
        Case $6D
            local0 = (Str filepos(se_getparamint()))
            local1 = $01
        Case $6E
            local0 = errorlog()
            local1 = $03
        Case $6F
            local69 = se_getparamint()
            local74 = se_getparamint()
            local75 = se_getparamint()
            local46 = se_getparamint()
            local0 = (Str writebytes(local69, local74, local75, local46))
            local1 = $01
        Case $70
            local69 = se_getparamint()
            local74 = se_getparamint()
            local75 = se_getparamint()
            local46 = se_getparamint()
            local0 = (Str readbytes(local69, local74, local75, local46))
            local1 = $01
        Case $71
            local0 = (Str createbank(se_getparamint()))
            local1 = $01
        Case $72
            freebank(se_getparamint())
        Case $73
            local0 = (Str banksize(se_getparamint()))
            local1 = $01
        Case $74
            local76 = se_getparamint()
            local46 = se_getparamint()
            resizebank(local76, local46)
        Case $75
            local76 = se_getparamint()
            local77 = se_getparamint()
            local78 = se_getparamint()
            local79 = se_getparamint()
            local46 = se_getparamint()
            copybank(local76, local77, local78, local79, local46)
        Case $76
            local69 = se_getparamint()
            local75 = se_getparamint()
            local0 = (Str peekbyte(local69, local75))
            local1 = $01
        Case $77
            local69 = se_getparamint()
            local75 = se_getparamint()
            local0 = (Str peekshort(local69, local75))
            local1 = $01
        Case $78
            local69 = se_getparamint()
            local75 = se_getparamint()
            local0 = (Str peekint(local69, local75))
            local1 = $01
        Case $79
            local69 = se_getparamint()
            local75 = se_getparamint()
            local0 = (Str peekfloat(local69, local75))
            local1 = $02
        Case $7A
            local69 = se_getparamint()
            local75 = se_getparamint()
            local80 = se_getparamint()
            pokebyte(local69, local75, local80)
        Case $7B
            local69 = se_getparamint()
            local75 = se_getparamint()
            local80 = se_getparamint()
            pokeshort(local69, local75, local80)
        Case $7C
            local69 = se_getparamint()
            local75 = se_getparamint()
            local80 = se_getparamint()
            pokeint(local69, local75, local80)
        Case $7D
            local69 = se_getparamint()
            local75 = se_getparamint()
            local80 = (Int se_getparamfloat())
            pokefloat(local69, local75, (Float local80))
        Case $7E
            local0 = (Str movex)
            local1 = $02
        Case $7F
            local0 = (Str movey)
            local1 = $02
        Case $80
            local0 = (Str movez)
            local1 = $02
        Case $81
            se_flipparams($08)
            local81 = (Float se_getflippedparamstring())
            local82 = (Float se_getflippedparamstring())
            local83 = (Float se_getflippedparamstring())
            local84 = (Float se_getflippedparamstring())
            local85 = (Float se_getflippedparamstring())
            local68 = (Float se_getflippedparamstring())
            local67 = (Float se_getflippedparamstring())
            local66 = (Float se_getflippedparamstring())
            local86 = createpivot($00)
            positionentity(local86, local66, local67, local68, $00)
            rotateentity(local86, local81, local82, 0.0, $00)
            moveentity(local86, local85, local84, local83)
            movex = entityx(local86, $00)
            movey = entityy(local86, $00)
            movez = entityz(local86, $00)
            freeentity(local86)
        Case $82
            local0 = (Str pointyaw)
            local1 = $02
        Case $83
            local0 = (Str pointpitch)
            local1 = $02
        Case $84
            se_flipparams($06)
            local83 = (Float se_getflippedparamstring())
            local84 = (Float se_getflippedparamstring())
            local85 = (Float se_getflippedparamstring())
            local68 = (Float se_getflippedparamstring())
            local67 = (Float se_getflippedparamstring())
            local66 = (Float se_getflippedparamstring())
            local86 = createpivot($00)
            local87 = createpivot($00)
            positionentity(local86, local66, local67, local68, $00)
            positionentity(local87, local85, local84, local83, $00)
            pointentity(local86, local87, 0.0)
            pointyaw = entityyaw(local86, $00)
            pointpitch = entitypitch(local86, $00)
            freeentity(local86)
            freeentity(local87)
        Case $85
            closefile(se_getparamint())
        Case $86
            local0 = readline(se_getparamint())
            local1 = $03
        Case $87
            local0 = (Str readint(se_getparamint()))
            local1 = $01
        Case $88
            local0 = (Str readfloat(se_getparamint()))
            local1 = $02
        Case $89
            local0 = (Str readshort(se_getparamint()))
            local1 = $01
        Case $8A
            local0 = (Str readbyte(se_getparamint()))
            local1 = $01
        Case $8B
            se_flipparams($02)
            local88 = se_getflippedparamstring()
            local89 = (Int se_getflippedparamstring())
            writeline(local89, local88)
        Case $8C
            se_flipparams($02)
            local88 = se_getflippedparamstring()
            local89 = (Int se_getflippedparamstring())
            writeint(local89, (Int local88))
        Case $8D
            se_flipparams($02)
            local88 = se_getflippedparamstring()
            local89 = (Int se_getflippedparamstring())
            writefloat(local89, (Float local88))
        Case $8E
            se_flipparams($02)
            local88 = se_getflippedparamstring()
            local89 = (Int se_getflippedparamstring())
            writeshort(local89, (Int local88))
        Case $8F
            se_flipparams($02)
            local88 = se_getflippedparamstring()
            local89 = (Int se_getflippedparamstring())
            writebyte(local89, (Int local88))
        Case $90
            local0 = (Str openfile(("multiplayer\" + se_getparamstring())))
            local1 = $01
        Case $91
            local0 = (Str readfile(("multiplayer\" + se_getparamstring())))
            local1 = $01
        Case $92
            local17 = ("multiplayer\" + se_tostringarg($00, ""))
            If (isfoldersecured(local17) = $00) Then
                Return $00
            EndIf
            local0 = (Str writefile(local17))
            local1 = $01
        Case $93
            local0 = (Str openfile(("workshop\" + se_getparamstring())))
            local1 = $01
        Case $94
            local0 = (Str readfile(("workshop\" + se_getparamstring())))
            local1 = $01
        Case $95
            local17 = ("workshop\" + se_tostringarg($00, ""))
            If (isfoldersecured(local17) = $00) Then
                Return $00
            EndIf
            local0 = (Str writefile(local17))
            local1 = $01
        Case $96
            local0 = multiplayer_version
            local1 = $03
        Case $97
            local0 = (Str millisecs())
            local1 = $01
        Case $98
            local0 = (Str serverping)
            local1 = $01
        Case $99
            local0 = nickname
            local1 = $03
        Case $9A
            msg = se_getparamstring()
            msgtimer = (Float (se_getparamint() * $46))
        Case $9B
            executeconsolecommand(se_getparamstring(), $01, $01)
        Case $9C
            local88 = se_getparamstring()
            local90 = se_getparamint()
            multiplayer_addchatmsg(local88, local90)
        Case $9D
        Case $9E
        Case $9F
        Case $A0
        Case $A1
            se_returnint(se_tointarg($00, $00))
            Return $00
        Case $A2
            se_returnfloat(se_tofloatarg($00, 0.0))
            Return $00
        Case $A3
            se_returnstring((Str se_tofloatarg($00, 0.0)))
            Return $00
        Case $A4
            se_returnfloat(floor(se_tofloatarg($00, 0.0)))
            Return $00
        Case $A5
            se_returnfloat(ceil(se_tofloatarg($00, 0.0)))
            Return $00
        Case $A6
            se_returnint((Sgn se_tointarg($00, $00)))
            Return $00
        Case $A7
            If (se_argtype($00) = $01) Then
                se_returnint((Int ceil((Float se_intarg($00, $00)))))
            Else
                se_returnfloat(ceil(se_tofloatarg($00, 0.0)))
            EndIf
            Return $00
        Case $A8
            se_returnfloat(sqr(se_tofloatarg($00, 0.0)))
            Return $00
        Case $A9
            se_returnfloat(sin(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AA
            se_returnfloat(cos(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AB
            se_returnfloat(tan(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AC
            se_returnfloat(asin(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AD
            se_returnfloat(acos(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AE
            se_returnfloat(atan(se_tofloatarg($00, 0.0)))
            Return $00
        Case $AF
            se_returnfloat(atan2(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0)))
            Return $00
        Case $B0
            se_returnfloat(exp(se_tofloatarg($00, 0.0)))
            Return $00
        Case $B1
            se_returnfloat(log(se_tofloatarg($00, 0.0)))
            Return $00
        Case $B2
            se_returnfloat(log10(se_tofloatarg($00, 0.0)))
            Return $00
        Case $B3
            se_returnfloat(rnd(se_tofloatarg($00, 0.0), se_tofloatarg($01, 0.0)))
            Return $00
        Case $B4
            se_returnint(rand(se_tointarg($00, $00), se_tointarg($01, $00)))
            Return $00
        Case $B5
            se_returnstring(se_tostringarg($00, ""))
            Return $00
        Case $B6
            se_returnstring(left(se_tostringarg($00, ""), se_tointarg($01, $00)))
            Return $00
        Case $B7
            se_returnstring(right(se_tostringarg($00, ""), se_tointarg($01, $00)))
            Return $00
        Case $B8
            se_returnstring(mid(se_tostringarg($00, ""), se_tointarg($01, $00), se_tointarg($02, $00)))
            Return $00
        Case $B9
            se_returnstring(replace(se_tostringarg($00, ""), se_tostringarg($01, ""), se_tostringarg($02, "")))
            Return $00
        Case $BA
            se_returnint(instr(se_tostringarg($00, ""), se_tostringarg($01, ""), se_tointarg($02, $00)))
            Return $00
        Case $BB
            se_returnstring(lower(se_tostringarg($00, "")))
            Return $00
        Case $BC
            se_returnstring(upper(se_tostringarg($00, "")))
            Return $00
        Case $BD
            se_returnstring(trim(se_tostringarg($00, "")))
            Return $00
        Case $BE
            se_returnstring(chr(se_tointarg($00, $00)))
            Return $00
        Case $BF
            se_returnint(asc(se_tostringarg($00, "")))
            Return $00
        Case $C0
            se_returnstring(hex(se_tointarg($00, $00)))
            Return $00
        Case $C1
            se_returnstring(bin(se_tointarg($00, $00)))
            Return $00
        Case $C2
            se_returnstring(string(se_tostringarg($00, ""), se_tointarg($01, $00)))
            Return $00
        Case $C3
            se_bl_array_create()
        Case $C4
            se_bl_array_push()
        Case $C5
            se_bl_array_pop()
        Case $C6
            se_bl_array_delete()
        Case $C7
            se_bl_array_sort()
        Case $C8
            se_bl_array_fromstring()
        Case $C9
            local0 = (Str mainfov)
            local1 = $02
        Case $CA
            local51 = se_getparamint()
            local95 = se_getparamint()
            local96 = se_getparamint()
            handleimage(local51, local95, local96)
        Case $CB
            local0 = (Str caninteract())
            local1 = $01
    End Select
    If (local1 = $00) Then
        local1 = $01
        local0 = "0"
    EndIf
    Select local1
        Case $01
            se_returnint((Int local0))
        Case $02
            se_returnfloat((Float local0))
        Case $03
            se_returnstring(local0)
    End Select
    Return $00
End Function
