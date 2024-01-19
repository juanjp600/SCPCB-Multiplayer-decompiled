Function se_executefunction%(arg0%, arg1%)
    Local local0$
    Local local1%
    Local local3%
    Local local4.itemtemplates
    Local local5.events
    Local local6.querys
    Local local7%
    Local local8.spawnpoint
    Local local9$
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14$
    Local local15%
    Local local16%
    Local local17%
    Local local18.steaminstances
    Local local19%
    Local local20$
    Local local21$
    Local local22$
    Local local23$
    Local local24$
    Local local25%
    Local local26%
    Local local27$
    Local local28%
    Local local29$
    Local local30%
    Local local31$
    Local local32%
    Local local33%
    Local local34%
    Local local35%
    Local local36%
    Local local37%
    Local local38$
    Local local39%
    Local local40%
    Local local41%
    Local local42$
    Local local43$
    Local local44%
    Local local45%
    Local local46%
    Local local47$
    Local local48$
    Local local49.items
    Local local50%
    Local local51#
    Local local52#
    Local local53#
    Local local54%
    Local local55$
    Local local56%
    Local local57%
    Local local58$
    Local local59%
    Local local60$
    Local local61%
    Local local62%
    Local local63.bs
    Local local64$
    Local local66%
    Local local67%
    Local local68$
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77%
    Local local78%
    Local local79%
    Local local80%
    Local local81.scriptsthread
    Local local82%
    Local local83%
    Local local84%
    Local local85%
    Local local86%
    Local local87%
    Local local88%
    Local local89$
    Local local90$
    Local local91%
    Local local92.npcs
    Local local93%
    Local local94$
    Local local95.events
    Local local96$
    Local local97$
    Local local98%
    Local local99$
    Local local101%
    Local local102%
    Local local103.players
    Local local104$
    Local local105$
    Local local106$
    Local local107$
    Local local108%
    Local local109%
    Local local110%
    Local local111%
    If (arg0 <> $00) Then
        If (invokefunctionaddress = $00) Then
            invokefunctionaddress = slua_get_calling_function()
            slua_set_global_handler(invokefunctionaddress)
            slua_load_functions()
            Return $00
        EndIf
    EndIf
    local0 = ""
    local1 = $00
    currentparam = $00
    currentluastate = arg0
    Select arg1
        Case $219
            halloweenindex = se_and_lua_tointarg($00)
        Case $21A
            newyearindex = se_and_lua_tointarg($00)
        Case local3
            multiplayer_breach_setrolecategory(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $21B
            multiplayer_breach_setmaxrolecount(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $1FE
            multiplayer_breach_createplayerrole(se_and_lua_tostringarg($00), se_and_lua_tointarg($01), se_and_lua_tofloatarg($02), se_and_lua_tostringarg($03), se_and_lua_tointarg($04), se_and_lua_tointarg($05), se_and_lua_tointarg($06), se_and_lua_tointarg($07))
        Case $1FF
            local0 = gettypename(se_and_lua_tointarg($00))
            local1 = $03
        Case $200
            multiplayer_breach_setrolesettings(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02), se_and_lua_tointarg($03), se_and_lua_tofloatarg($04), se_and_lua_tointarg($05), se_and_lua_tostringarg($06), se_and_lua_tointarg($07), se_and_lua_tointarg($08))
        Case $201
            multiplayer_breach_setroleeffects(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tointarg($04), se_and_lua_tointarg($05), se_and_lua_tointarg($06), se_and_lua_tointarg($07), se_and_lua_tointarg($08), se_and_lua_tointarg($09), se_and_lua_tointarg($0A))
        Case $202
            multiplayer_breach_setroleambientsound(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tostringarg($02))
        Case $203
            multiplayer_breach_setroleinstruction(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $204
            multiplayer_breach_setroledeadanimation(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $205
            multiplayer_breach_setrolehitboxscales(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03))
        Case $206
            multiplayer_breach_setrolebone(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tostringarg($02))
        Case $207
            multiplayer_breach_setroleanimation(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02), se_and_lua_tointarg($03), se_and_lua_tofloatarg($04))
        Case $208
            multiplayer_breach_setrolearmedanimation(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02), se_and_lua_tointarg($03), se_and_lua_tofloatarg($04))
        Case $209
            multiplayer_breach_markasfriend(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $20A
            multiplayer_breach_roletakerolespawn(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $20B
            multiplayer_breach_setrolepositionsoffset(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03))
        Case $20C
            multiplayer_breach_setroleholdinggrenade(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03))
        Case $20D
            multiplayer_breach_setroleholdingitem(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02))
        Case $20E
            multiplayer_breach_setrolehandcuff(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tostringarg($05), se_and_lua_tofloatarg($06), se_and_lua_tofloatarg($07), se_and_lua_tofloatarg($08))
        Case $20F
            multiplayer_breach_allowroleweaponattaches(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $210
            multiplayer_breach_allowitemsattaches(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $211
            multiplayer_breach_markroleasscp(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $212
            multiplayer_breach_markas035(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $213
            multiplayer_breach_markas049(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $214
            local0 = (Str multiplayer_breach_isa035(se_and_lua_tointarg($00)))
            local1 = $01
        Case $215
            local0 = (Str multiplayer_breach_isa049(se_and_lua_tointarg($00)))
            local1 = $01
        Case $216
            local0 = (Str multiplayer_isafriend(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $217
            local0 = (Str multiplayer_breach_getmaxhp(se_and_lua_tointarg($00)))
            local1 = $01
        Case $218
            local0 = (Str multiplayer_breach_getrolescale(se_and_lua_tointarg($00)))
            local1 = $02
        Case $384
            addlog(((("Detected error #" + (Str se_and_lua_tointarg($00))) + ": ") + se_and_lua_tostringarg($01)), $00, $00, $00)
        Case $1FD
            local4 = createitemtemplate(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tofloatarg($05), "", "", $00, $09, $00)
            local4\Field3 = se_and_lua_tointarg($06)
            local0 = (Str local4\Field0)
            local1 = $01
        Case $1F7
            server\Field79 = ($01 - se_getparamint())
        Case $1F8
            server\Field77 = se_getparamint()
        Case $1F9
            server\Field78 = se_getparamint()
        Case $1FA
            player[se_and_lua_tointarg($00)]\Field120 = se_and_lua_tointarg($01)
        Case $1FB
            player[se_and_lua_tointarg($00)]\Field122 = se_and_lua_tointarg($01)
        Case $1FC
            player[se_and_lua_tointarg($00)]\Field121 = se_and_lua_tointarg($01)
        Case $1FC
            local0 = (Str (player[se_and_lua_tointarg($01)]\Field120 = $01))
            local1 = $01
        Case $1EF
            local5 = createevent(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02), se_and_lua_tofloatarg($03))
            If (local5 <> Null) Then
                local0 = (Str local5\Field15)
            EndIf
            local1 = $01
        Case $1ED
            local0 = (Str player[se_and_lua_tointarg($00)]\Field56)
            local1 = $01
        Case $1EB
            onplayerconsole(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02))
        Case $1E7
            local0 = (Str createcube($00))
            local1 = $01
        Case $1E8
            local0 = (Str createsphere($08, $00))
            local1 = $01
        Case $1E9
            local0 = (Str createcylinder($08, $01, $00))
            local1 = $01
        Case $1EA
            local0 = (Str createcone($08, $01, $00))
            local1 = $01
        Case $1E5
            local0 = (Str getplayerdownloadingcount(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1E6
            local1 = $01
            For local6 = Each querys
                If (local6\Field3 = se_and_lua_tointarg($00)) Then
                    If (local6\Field0 = se_and_lua_tostringarg($01)) Then
                        local0 = "1"
                        Exit
                    EndIf
                EndIf
            Next
        Case $1E4
            local0 = (Str createpivot($00))
            local1 = $01
        Case $1E1
            local0 = (Str player[se_getparamint()]\Field173)
            local1 = $02
        Case $1E0
            player[se_and_lua_tointarg($00)]\Field173 = se_and_lua_tofloatarg($01)
        Case $1E2
            player[se_and_lua_tointarg($00)]\Field94 = se_and_lua_tointarg($01)
        Case $1E3
            local0 = (Str player[se_getparamint()]\Field94)
            local1 = $01
        Case $1DF
            turnentity(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tointarg($04))
        Case $1DC
            object_sound_create(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), $00)
        Case $1DD
            object_sound_create(se_and_lua_tointarg($01), se_and_lua_tostringarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tointarg($00))
        Case $1DA
            local0 = (Str downloadfile(se_and_lua_tostringarg($00)))
            local1 = $01
        Case $1DB
            closetcpstream(se_and_lua_tointarg($00))
        Case $1C6
            local0 = (Str createsprite($00))
            local1 = $01
        Case $1C7
            local0 = (Str loadsprite(se_and_lua_tostringarg($00), se_and_lua_tointarg($01), $00))
            local1 = $01
        Case $1C8
            spriteviewmode(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $1C9
            scalesprite(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02))
        Case $1CA
            entityfx(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $1CB
            entityblend(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $1CC
            showentity(se_and_lua_tointarg($00))
        Case $1CD
            hideentity(se_and_lua_tointarg($00))
        Case $1CE
            local0 = (Str getparent(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1CF
            entityautofade(se_and_lua_tointarg($00), se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01))
        Case $1D0
            entitycolor(se_and_lua_tointarg($00), (Float se_and_lua_tointarg($01)), (Float se_and_lua_tointarg($02)), (Float se_and_lua_tointarg($03)))
        Case $1D1
            entityshininess(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01))
        Case $1D2
            entityalpha(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01))
        Case $1D3
            entitytexture(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02), se_and_lua_tointarg($03))
        Case $1D4
            local0 = (Str createtexture(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02), se_and_lua_tointarg($03)))
            local1 = $01
        Case $1D5
            local0 = (Str loadtexture(se_and_lua_tostringarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $1D6
            scaletexture(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02))
        Case $1D7
            local0 = (Str texturewidth(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1D8
            local0 = (Str textureheight(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1D9
            entityparent(se_and_lua_tointarg($00), se_and_lua_tointarg($01), $01)
        Case $1C5
            server\Field72 = se_getparamint()
        Case $1C4
            server\Field73 = se_getparamint()
        Case $1BE
            local0 = (Str entityscalex2(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1BF
            local0 = (Str entityscaley2(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1C0
            local0 = (Str entityscalez2(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1C1
            local0 = (Str meshwidth(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1C2
            local0 = (Str meshheight(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1C3
            local0 = (Str meshdepth(se_and_lua_tointarg($00)))
            local1 = $02
        Case $1BD
            server\Field46 = se_and_lua_tostringarg($00)
            restartserver("")
        Case $1BC
            pointentity(se_and_lua_tointarg($00), se_and_lua_tointarg($01), 0.0)
        Case $1BB
            local0 = (Str player[se_and_lua_tointarg($00)]\Field69)
            local1 = $01
        Case $1BA
            local0 = (Str entitydistance(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B9
            local0 = (Str player[se_and_lua_tointarg($00)]\Field68)
            local1 = $01
        Case $1B7
            local0 = (Str deltayaw(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B8
            local0 = (Str deltapitch(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1A8
            resetentity(se_and_lua_tointarg($00))
        Case $1A9
            entityradius(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), 0.0)
        Case $1AA
            entitybox(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05), se_and_lua_tofloatarg($06))
        Case $1AB
            entitytype(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $1AC
            entitypickmode(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $1AD
            local0 = (Str entitycollided(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $1AE
            local0 = (Str countcollisions(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1AF
            local0 = (Str collisionx(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B0
            local0 = (Str collisiony(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B1
            local0 = (Str collisionz(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B2
            local0 = (Str collisionnx(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B3
            local0 = (Str collisionny(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B4
            local0 = (Str collisionnz(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B5
            local0 = (Str collisionentity(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $1B6
            local0 = (Str getentitytype(se_and_lua_tointarg($00)))
            local1 = $01
        Case $1A5
            local0 = (Str player[se_getparamint()]\Field0)
            local1 = $02
        Case $1A6
            local0 = (Str player[se_getparamint()]\Field1)
            local1 = $02
        Case $1A7
            local0 = (Str player[se_getparamint()]\Field2)
            local1 = $02
        Case $1A4
            local7 = se_getparamint()
            player[local7]\Field32 = se_getparamint()
            mp_setplayerroomid(player[local7], room[player[local7]\Field32])
        Case $1A3
            changeplayersteamid(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $19F
            local8 = (New spawnpoint)
            local8\Field0 = se_and_lua_tointarg($00)
            local8\Field2 = se_and_lua_tostringarg($01)
            local8\Field3 = se_and_lua_tofloatarg($02)
            local8\Field4 = se_and_lua_tofloatarg($03)
            local8\Field5 = se_and_lua_tofloatarg($04)
            local8\Field1 = $FFFFFFFF
            local0 = (Str (Handle local8))
            local1 = $01
        Case $1A0
            local8 = (New spawnpoint)
            local8\Field1 = se_and_lua_tointarg($00)
            local8\Field2 = se_and_lua_tostringarg($01)
            local8\Field3 = se_and_lua_tofloatarg($02)
            local8\Field4 = se_and_lua_tofloatarg($03)
            local8\Field5 = se_and_lua_tofloatarg($04)
            local8\Field0 = $FFFFFFFF
            local0 = (Str (Handle local8))
            local1 = $01
        Case $1A1
            Delete (Object.spawnpoint se_and_lua_tointarg($00))
        Case $1A2
            local0 = (Str ((Object.spawnpoint se_and_lua_tointarg($00)) <> Null))
            local1 = $01
        Case $199
            player[se_and_lua_tointarg($00)]\Field162 = se_and_lua_tointarg($01)
        Case $195
            changeplayersize(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $196
            local0 = (Str player[se_and_lua_tointarg($00)]\Field28)
            local1 = $02
        Case $193
            local0 = (Str curvevalue(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02)))
            local1 = $02
        Case $194
            local0 = (Str curveangle(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02)))
            local1 = $02
        Case $16B
            dllfunctionvoid_0()
        Case $16C
            dllfunctionvoid_1(se_and_lua_tostringarg($00))
        Case $16D
            dllfunctionvoid_2(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01))
        Case $16E
            dllfunctionvoid_3(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02))
        Case $16F
            dllfunctionvoid_4(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03))
        Case $170
            dllfunctionvoid_5(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04))
        Case $171
            dllfunctionvoid_6(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05))
        Case $172
            dllfunctionvoid_7(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06))
        Case $173
            dllfunctionvoid_8(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07))
        Case $174
            dllfunctionvoid_9(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07), se_and_lua_tostringarg($08))
        Case $175
            local0 = (Str dllfunctionint_0())
            local1 = $01
        Case $176
            local0 = (Str dllfunctionint_1(se_and_lua_tostringarg($00)))
            local1 = $01
        Case $177
            local0 = (Str dllfunctionint_2(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01)))
            local1 = $01
        Case $178
            local0 = (Str dllfunctionint_3(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02)))
            local1 = $01
        Case $179
            local0 = (Str dllfunctionint_4(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03)))
            local1 = $01
        Case $17A
            local0 = (Str dllfunctionint_5(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04)))
            local1 = $01
        Case $17B
            local0 = (Str dllfunctionint_6(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05)))
            local1 = $01
        Case $17C
            local0 = (Str dllfunctionint_7(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06)))
            local1 = $01
        Case $17D
            local0 = (Str dllfunctionint_8(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07)))
            local1 = $01
        Case $17E
            local0 = (Str dllfunctionint_9(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07), se_and_lua_tostringarg($08)))
            local1 = $01
        Case $17F
            local0 = (Str dllfunctionfloat_0())
            local1 = $02
        Case $180
            local0 = (Str dllfunctionfloat_1(se_and_lua_tostringarg($00)))
            local1 = $02
        Case $181
            local0 = (Str dllfunctionfloat_2(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01)))
            local1 = $02
        Case $182
            local0 = (Str dllfunctionfloat_3(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02)))
            local1 = $02
        Case $183
            local0 = (Str dllfunctionfloat_4(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03)))
            local1 = $02
        Case $184
            local0 = (Str dllfunctionfloat_5(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04)))
            local1 = $02
        Case $185
            local0 = (Str dllfunctionfloat_6(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05)))
            local1 = $02
        Case $186
            local0 = (Str dllfunctionfloat_7(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06)))
            local1 = $02
        Case $187
            local0 = (Str dllfunctionfloat_8(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07)))
            local1 = $02
        Case $188
            local0 = (Str dllfunctionfloat_9(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07), se_and_lua_tostringarg($08)))
            local1 = $02
        Case $189
            local0 = dllfunctionstring_0()
            local1 = $03
        Case $18A
            local0 = dllfunctionstring_1(se_and_lua_tostringarg($00))
            local1 = $03
        Case $18B
            local0 = dllfunctionstring_2(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01))
            local1 = $03
        Case $18C
            local0 = dllfunctionstring_3(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02))
            local1 = $03
        Case $18D
            local0 = dllfunctionstring_4(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03))
            local1 = $03
        Case $18E
            local0 = dllfunctionstring_5(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04))
            local1 = $03
        Case $18F
            local0 = dllfunctionstring_6(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05))
            local1 = $03
        Case $190
            local0 = dllfunctionstring_7(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06))
            local1 = $03
        Case $191
            local0 = dllfunctionstring_8(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07))
            local1 = $03
        Case $192
            local0 = dllfunctionstring_9(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tostringarg($05), se_and_lua_tostringarg($06), se_and_lua_tostringarg($07), se_and_lua_tostringarg($08))
            local1 = $03
        Case $169
            local9 = se_getparamstring()
            local10 = se_getparamint()
            addcentralserver(local9, local10)
        Case $16A
            connecttocentralserver((Str local11), local12, $01)
        Case $166
            local13 = se_getparamint()
            local14 = se_getparamstring()
            local15 = se_getparamint()
            local16 = se_getparamint()
            local17 = se_getparamint()
            createsteaminstance(local13, local14, local15, local16, local17, $00)
        Case $168
            local13 = se_getparamint()
            For local18 = Each steaminstances
                If (local18\Field0 = local13) Then
                    Delete local18
                EndIf
            Next
        Case $167
            local0 = ""
            local1 = $03
            local13 = se_getparamint()
            For local18 = Each steaminstances
                If (local18\Field0 = local13) Then
                    local0 = local18\Field1
                    Exit
                EndIf
            Next
        Case $164
            local19 = se_getparamint()
            local20 = se_getparamstring()
            server\Field61[local19] = local20
        Case $165
            local0 = server\Field61[se_getparamint()]
            local1 = $01
        Case $163
            server\Field67 = se_getparamint()
        Case $162
            local0 = (Str server\Field67)
            local1 = $01
        Case $15F
            server\Field66 = se_getparamint()
        Case $15C
            end()
        Case $151
            local21 = se_getparamstring()
            local10 = se_getparamint()
            local22 = se_getparamstring()
            local23 = se_getparamstring()
            local24 = se_getparamstring()
            local25 = se_getparamint()
            local0 = (Str opensqlstream(local21, local10, local22, local23, local24, local25))
            local1 = $01
        Case $152
            local0 = (Str sqlconnected(se_getparamint()))
            local1 = $01
        Case $153
            local26 = se_getparamint()
            local27 = se_getparamstring()
            local0 = (Str sqlquery(local26, local27))
            local1 = $01
        Case $154
            local0 = (Str sqlrowcount(se_getparamint()))
            local1 = $01
        Case $155
            local0 = (Str sqlfetchrow(se_getparamint()))
            local1 = $01
        Case $156
            local0 = (Str sqlfieldcount(se_getparamint()))
            local1 = $01
        Case $157
            local28 = se_getparamint()
            local29 = se_getparamstring()
            local0 = readsqlfield(local28, local29)
            local1 = $03
        Case $158
            local28 = se_getparamint()
            local30 = se_getparamint()
            local0 = readsqlfieldindex(local28, local30)
            local1 = $03
        Case $159
            local0 = (Str freesqlquery(se_getparamint()))
            local1 = $01
        Case $15A
            local0 = (Str freesqlrow(se_getparamint()))
            local1 = $01
        Case $15B
            local0 = (Str closesqlstream(se_getparamint()))
            local1 = $01
        Case $12A
            local31 = se_getparamstring()
            local32 = se_getparamint()
            local33 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str opendatabase(local31, local32, local33, local34))
            local1 = $01
        Case $12B
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str closedatabase(local35, local34))
            local1 = $01
        Case $12C
            local36 = se_getparamint()
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str setdatabasetimeout(local36, local35, local34))
            local1 = $01
        Case $12D
            local0 = databaseversion()
            local1 = $03
        Case $12E
            local35 = se_getparamint()
            local0 = (Str lastrowidinserted(local35))
            local1 = $01
        Case $12F
            local35 = se_getparamint()
            local0 = (Str rowschangedbylaststatement(local35))
            local1 = $01
        Case $130
            local35 = se_getparamint()
            local0 = (Str rowschangedthissession(local35))
            local1 = $01
        Case $131
            local35 = se_getparamint()
            local0 = (Str autocommitison(local35))
            local1 = $01
        Case $132
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str begintransaction(local35, local34))
            local1 = $01
        Case $133
            local37 = se_getparamint()
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str committransaction(local37, local35, local34))
            local1 = $01
        Case $134
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str rollbacktransaction(local35, local34))
            local1 = $01
        Case $135
            local35 = se_getparamint()
            local0 = (Str lastdatabaseerrorcode(local35))
            local1 = $01
        Case $136
            local35 = se_getparamint()
            local0 = lastdatabaseerrormessage(local35)
            local1 = $03
        Case $137
            local35 = se_getparamint()
            local0 = (Str interruptdatabase(local35))
            local1 = $01
        Case $138
            local38 = se_getparamstring()
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str executesql(local38, local35, local34))
            local1 = $01
        Case $139
            local38 = se_getparamstring()
            local35 = se_getparamint()
            local33 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str preparesql(local38, local35, local33, local34))
            local1 = $01
        Case $13A
            local35 = se_getparamint()
            local39 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str getnextdatarow(local35, local39, local34))
            local1 = $01
        Case $13B
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str finalisesql(local35, local34))
            local1 = $01
        Case $13C
            local35 = se_getparamint()
            local34 = se_getparamint()
            local0 = (Str resetsql(local35, local34))
            local1 = $01
        Case $13D
            local35 = se_getparamint()
            local0 = (Str sqlhasexpired(local35))
            local1 = $01
        Case $13E
            local35 = se_getparamint()
            local0 = (Str getdatabasehandlefromstatementhandle(local35))
            local1 = $01
        Case $13F
            local35 = se_getparamint()
            local0 = (Str getcolumncount(local35))
            local1 = $01
        Case $140
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = getcolumnname(local40, local35)
            local1 = $03
        Case $141
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str getcolumntype(local40, local35))
            local1 = $01
        Case $142
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = getcolumndeclaredtype(local40, local35)
            local1 = $03
        Case $143
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str getcolumnsize(local40, local35))
            local1 = $01
        Case $144
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str getcolumnvalueasinteger(local40, local35))
            local1 = $01
        Case $145
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str getcolumnvalueasfloat(local40, local35))
            local1 = $02
        Case $146
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = getcolumnvalueasstring(local40, local35)
            local1 = $03
        Case $147
            local40 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str getcolumnvalueasblob(local40, local35))
            local1 = $01
        Case $148
            local35 = se_getparamint()
            local0 = (Str sqlparametercount(local35))
            local1 = $01
        Case $149
            local41 = se_getparamint()
            local35 = se_getparamint()
            local0 = sqlparametername(local41, local35)
            local1 = $03
        Case $14A
            local42 = se_getparamstring()
            local35 = se_getparamint()
            local0 = (Str sqlparameterindex(local42, local35))
            local1 = $01
        Case $14B
            local41 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str bindsqlparameterasnull(local41, local35))
            local1 = $01
        Case $14C
            local41 = se_getparamint()
            local43 = (Str se_getparamint())
            local35 = se_getparamint()
            local0 = (Str bindsqlparameterasinteger(local41, (Int local43), local35))
            local1 = $01
        Case $14D
            local41 = se_getparamint()
            local43 = (Str se_getparamfloat())
            local35 = se_getparamint()
            local0 = (Str bindsqlparameterasfloat(local41, (Float local43), local35))
            local1 = $01
        Case $14E
            local41 = se_getparamint()
            local43 = se_getparamstring()
            local35 = se_getparamint()
            local0 = (Str bindsqlparameterasstring(local41, local43, local35))
            local1 = $01
        Case $14F
            local41 = se_getparamint()
            local44 = se_getparamint()
            local45 = se_getparamint()
            local35 = se_getparamint()
            local0 = (Str bindsqlparameterasblob(local41, local44, local45, local35))
            local1 = $01
        Case $150
            local35 = se_getparamint()
            local46 = se_getparamint()
            local0 = (Str transfersqlbindings(local35, local46))
            local1 = $01
        Case $150
            local47 = se_getparamstring()
            local34 = se_getparamint()
            local48 = se_getparamstring()
            local0 = (Str sqlite3_errorhasoccurred(local47, local34, local48))
            local1 = $01
        Case $01
            player[se_and_lua_tointarg($00)]\Field84 = se_and_lua_tofloatarg($01)
        Case $02
            local0 = (Str player[se_getparamint()]\Field84)
            local1 = $02
        Case $1F1
            local0 = (Str player[se_getparamint()]\Field138)
            local1 = $01
        Case $03
            local7 = se_getparamint()
            player[local7]\Field138 = se_getparamint()
            If (player[local7]\Field138 <> 0) Then
                For local49 = Each items
                    If (local49\Field22 = local7) Then
                        playerdropitem(local49)
                    EndIf
                Next
            EndIf
        Case $04
            local0 = (Str player[se_getparamint()]\Field129)
            local1 = $01
        Case $05
            local7 = se_getparamint()
            giveplayerhealth(local7, (Float se_getparamint()), "")
        Case $06
            local7 = se_getparamint()
            player[local7]\Field118 = se_getparamfloat()
        Case $19E
            local0 = (Str player[se_and_lua_tointarg($00)]\Field118)
            local1 = $02
        Case $07
            local7 = se_getparamint()
            mp_sendblinktimer(local7, se_getparamfloat())
        Case $08
            local0 = (Str zipapi_compress(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $09
            local0 = (Str zipapi_uncompress(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $01
        Case $0A
            deactivatewarheads($00)
        Case $0B
            gameinfo\Field5\Field8 = $00
            spawnmtf()
        Case $1F0
            gameinfo\Field5\Field8 = $01
            spawnmtf()
        Case $0C
            activatewarheads("NULL", $00, $00)
        Case $0D
            local7 = se_getparamint()
            If (isvalidplayer(local7) <> 0) Then
                local0 = (Str getplayerzone(local7))
                local1 = $01
            EndIf
        Case $0E
            local0 = (Str (gameinfo\Field5\Field1 - millisecs()))
            local1 = $01
        Case $0F
            addversion(se_getparamstring())
        Case $10
            local0 = (Str player[se_getparamint()]\Field61)
            local1 = $02
        Case $11
            local7 = se_getparamint()
            player[local7]\Field61 = se_getparamfloat()
        Case $12
            local0 = (Str player[se_getparamint()]\Field16)
            local1 = $02
        Case $13
            local7 = se_getparamint()
            player[local7]\Field16 = se_getparamfloat()
        Case $14
            local0 = (Str createcamera($00))
            local1 = $01
            cameraviewport((Int local0), $00, $00, $780, $438)
        Case $15
            local50 = se_getparamint()
            local0 = (Str entityinview(local50, se_getparamint()))
            local1 = $01
        Case $16
            local50 = se_getparamint()
            local0 = (Str entityvisible(local50, se_getparamint()))
            local1 = $01
        Case $17
            local0 = (Str entityx(se_getparamint(), $01))
            local1 = $02
        Case $18
            local0 = (Str entityy(se_getparamint(), $01))
            local1 = $02
        Case $19
            local0 = (Str entityz(se_getparamint(), $01))
            local1 = $02
        Case $1A
            local0 = (Str entitypitch(se_getparamint(), $01))
            local1 = $02
        Case $1B
            local0 = (Str entityyaw(se_getparamint(), $01))
            local1 = $02
        Case $1C
            local0 = (Str entityroll(se_getparamint(), $01))
            local1 = $02
        Case $1D
            local50 = se_getparamint()
            local0 = (Str entitypick(local50, se_getparamfloat()))
            local1 = $01
        Case $1E
            local50 = se_getparamint()
            local51 = se_getparamfloat()
            local52 = se_getparamfloat()
            local53 = se_getparamfloat()
            positionentity(local50, local51, local52, local53, se_getparamint())
        Case $1F
            local50 = se_getparamint()
            local51 = se_getparamfloat()
            local52 = se_getparamfloat()
            local53 = se_getparamfloat()
            rotateentity(local50, local51, local52, local53, se_getparamint())
        Case $20
            If (se_and_lua_tointarg($04) = $00) Then
                local50 = se_getparamint()
                local51 = se_getparamfloat()
                local52 = se_getparamfloat()
                local53 = se_getparamfloat()
                moveentity(local50, local51, local52, local53)
            Else
                local50 = se_getparamint()
                local51 = se_getparamfloat()
                local52 = se_getparamfloat()
                local53 = se_getparamfloat()
                translateentity(local50, local51, local52, local53, $00)
            EndIf
        Case $21
            local50 = se_getparamint()
            local51 = se_getparamfloat()
            scaleentity(local50, local51, local51, local51, $00)
        Case $22
            local50 = se_getparamint()
            entitytype(local50, (se_getparamint() Shl $01), $00)
        Case $23
            freeentity(se_getparamint())
        Case $24
            local50 = se_getparamint()
            local51 = se_getparamfloat()
            setanimtime(local50, local51, $00)
        Case $25
            local0 = (Str fpsfactor)
            local1 = $02
        Case $26
            local7 = se_getparamint()
            local54 = se_getparamint()
            If (player[local7] <> Null) Then
                udp_writebyte($72)
                udp_writebyte($01)
                udp_writebytes(local54, $00, banksize(local54))
                udp_sendmessage(local7)
            EndIf
        Case $27
            local7 = se_getparamint()
            local31 = se_getparamstring()
            local55 = se_getparamstring()
            sendfile(local7, local31, local55, $01, $00, $00)
        Case $28
            local7 = se_getparamint()
            local31 = se_getparamstring()
            local55 = se_getparamstring()
            sendfile(local7, local31, local55, $00, se_and_lua_tointarg($03), se_and_lua_tointarg($04))
        Case $29
            server\Field43 = se_getparamstring()
            addlog(("Game state changed to " + server\Field43), $00, $00, $00)
        Case $2A
            server\Field5 = se_getparamstring()
            addlog(("Server name changed to " + server\Field5), $00, $00, $00)
        Case $2B
            server\Field42 = se_getparamstring()
            addlog(("Description changed to " + server\Field42), $00, $00, $00)
        Case $2C
            rcon_password(se_getparamstring())
            addlog(("Password changed to " + server\Field14), $00, $00, $00)
        Case $2D
            gameinfo\Field5\Field1 = (millisecs() + se_getparamint())
            addlog(("Breach timer changed to " + (Str (gameinfo\Field5\Field1 - millisecs()))), $00, $00, $00)
        Case $125
            gameinfo\Field5\Field7 = (millisecs() + se_getparamint())
        Case $127
            local0 = (Str (gameinfo\Field5\Field7 - millisecs()))
            local1 = $01
        Case $128
            local0 = (Str (gameinfo\Field5\Field5 - millisecs()))
            local1 = $01
        Case $129
            gameinfo\Field5\Field5 = (millisecs() + se_getparamint())
        Case $2E
            server\Field2 = se_getparamint()
            addlog(("No cheat changed to " + (Str server\Field2)), $00, $00, $00)
        Case $2F
            local0 = (Str player[se_getparamint()]\Field60)
            local1 = $01
        Case $30
            local7 = se_getparamint()
            local56 = se_getparamint()
            player[local7]\Field60 = (Float local56)
        Case $31
            server\Field41 = (server\Field41 = $00)
        Case $32
            reloadapplication()
        Case $33
            local58 = se_getparamstring()
            For local59 = $01 To len(local58) Step $01
                local57 = (local57 + (asc(mid(local58, local59, $01)) Shl ((local59 - $01) Shl $03)))
            Next
            local0 = (Str local57)
            local1 = $01
        Case $34
            removetimer((Object.timers se_getparamint()))
        Case $35
            local60 = se_getparamstring()
            local61 = se_getparamint()
            local62 = se_getparamint()
            local63 = createbytestream($174)
            If (currentluastate = $00) Then
                For local59 = $03 To (se_arguments_number - $01) Step $01
                    If (se_argtype(local59) <> $00) Then
                        Select se_argtype(local59)
                            Case $01
                                local64 = (local64 + "i")
                                bytestreamwriteint(local63, se_and_lua_tointarg(local59))
                            Case $02
                                local64 = (local64 + "f")
                                bytestreamwritefloat(local63, se_and_lua_tofloatarg(local59))
                            Case $03
                                local64 = (local64 + "s")
                                bytestreamwritestring(local63, se_and_lua_tostringarg(local59))
                        End Select
                    EndIf
                Next
                local0 = (Str settimer(se_current_function\Field1, local60, local61, local62, local64, local63, $00))
            Else
                For local59 = $04 To $20 Step $01
                    If (slua_is_none_or_nil(currentluastate, local59) = $00) Then
                        If (slua_is_integer(currentluastate, local59) <> 0) Then
                            local64 = (local64 + "i")
                            bytestreamwriteint(local63, slua_to_integer(currentluastate, local59))
                        ElseIf (slua_is_number(currentluastate, local59) <> 0) Then
                            local64 = (local64 + "f")
                            bytestreamwritefloat(local63, slua_to_number(currentluastate, local59))
                        ElseIf (slua_is_string(currentluastate, local59) <> 0) Then
                            local64 = (local64 + "s")
                            bytestreamwritestring(local63, slua_to_string(currentluastate, local59))
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
                local0 = (Str settimer(Null, local60, local61, local62, local64, local63, currentluastate))
            EndIf
            local1 = $01
        Case $36
            bytestreamwritechar(scriptbstream, se_getparamint())
        Case $37
            bytestreamwriteshort(scriptbstream, se_getparamint())
        Case $38
            bytestreamwriteint(scriptbstream, se_getparamint())
        Case $39
            bytestreamwritefloat(scriptbstream, se_getparamfloat())
        Case $3A
            debuglog(se_getparamstring())
        Case $3B
            local0 = (Str eof(se_getparamint()))
            local1 = $01
        Case $3C
            local0 = (Str asc(se_getparamstring()))
            local1 = $01
        Case $3D
            local0 = chr(se_getparamint())
            local1 = $03
        Case $3E
            local0 = (Str filetype(se_getparamstring()))
            local1 = $01
        Case $3F
            local0 = (Str filesize(se_getparamstring()))
            local1 = $01
        Case $40
            local66 = se_getparamint()
            local67 = se_getparamint()
            seekfile(local66, local67)
        Case $41
            local0 = (Str filepos(se_getparamint()))
            local1 = $01
        Case $42
            local0 = errorlog()
            local1 = $03
        Case $1F6
            adderrorlog(se_and_lua_tostringarg($00))
        Case $43
            local68 = se_getparamstring()
            If (local68 = "voice") Then
                local0 = "29"
            EndIf
            local1 = $01
        Case $44
            local7 = se_getparamint()
            local69 = se_getparamint()
            local70 = se_getparamint()
            local71 = se_getparamint()
            local72 = se_getparamint()
            local73 = local69
            If (local73 <> $1D) Then
                local1 = $01
                local0 = "0"
            Else
                udp_writebyte(local69)
                udp_writebytes(getbytestreamdata(scriptbstream), $00, getbytestreamdatasize(scriptbstream))
                udp_writebytes(local70, local71, local72)
                udp_sendmessage(local7)
                local1 = $01
                local0 = "1"
                bytestreamreset(scriptbstream)
            EndIf
        Case $45
            local54 = se_getparamint()
            local74 = se_getparamint()
            local71 = se_getparamint()
            local72 = se_getparamint()
            local0 = (Str writebytes(local54, local74, local71, local72))
            local1 = $01
        Case $46
            local54 = se_getparamint()
            local74 = se_getparamint()
            local71 = se_getparamint()
            local72 = se_getparamint()
            local0 = (Str readbytes(local54, local74, local71, local72))
            local1 = $01
        Case $47
            local0 = (Str createbank(se_getparamint()))
            local1 = $01
        Case $48
            freebank(se_getparamint())
        Case $49
            local0 = (Str banksize(se_getparamint()))
            local1 = $01
        Case $4A
            local75 = se_getparamint()
            local72 = se_getparamint()
            resizebank(local75, local72)
        Case $4B
            local75 = se_getparamint()
            local76 = se_getparamint()
            local77 = se_getparamint()
            local78 = se_getparamint()
            local72 = se_getparamint()
            copybank(local75, local76, local77, local78, local72)
        Case $4C
            local54 = se_getparamint()
            local71 = se_getparamint()
            local0 = (Str peekbyte(local54, local71))
            local1 = $01
        Case $4D
            local54 = se_getparamint()
            local71 = se_getparamint()
            local0 = (Str peekshort(local54, local71))
            local1 = $01
        Case $4E
            local54 = se_getparamint()
            local71 = se_getparamint()
            local0 = (Str peekint(local54, local71))
            local1 = $01
        Case $4F
            local54 = se_getparamint()
            local71 = se_getparamint()
            local0 = (Str peekfloat(local54, local71))
            local1 = $02
        Case $50
            local54 = se_getparamint()
            local71 = se_getparamint()
            local79 = se_getparamint()
            pokebyte(local54, local71, local79)
        Case $51
            local54 = se_getparamint()
            local71 = se_getparamint()
            local79 = se_getparamint()
            pokeshort(local54, local71, local79)
        Case $52
            local54 = se_getparamint()
            local71 = se_getparamint()
            local79 = se_getparamint()
            pokeint(local54, local71, local79)
        Case $53
            local54 = se_getparamint()
            local71 = se_getparamint()
            local79 = (Int se_getparamfloat())
            pokefloat(local54, local71, (Float local79))
        Case $54
            server\Field39 = (server\Field39 = $00)
            server\Field9 = server\Field39
        Case $55
            var_remove(se_getparamstring())
        Case $56
            var_setvalue(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01))
        Case $57
            local0 = var_getvalue(se_getparamstring())
            local1 = $03
        Case $58
            player_var_remove(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $59
            player_var_setvalue(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02))
        Case $5A
            local0 = player_var_getvalue(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
            local1 = $03
        Case $5B
            se_array_addelements(se_arrayarg($00), se_intarg($01, $00), se_intarg($02, $00))
        Case $19C
            objects_stream_update()
        Case $5C
            local0 = (Str multiplayer_object[se_getparamint()]\Field11)
            local1 = $01
        Case $5D
            object_update_visible(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $19B
            preparemodelidentifier(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $19A
            object_update_lerp(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $5E
            server\Field38 = se_getparamstring()
            server\Field35 = (Float se_getparamstring())
            server\Field36 = (Float se_getparamstring())
            server\Field37 = (Float se_getparamstring())
        Case $5F
            local7 = se_getparamint()
            player[local7]\Field57 = se_getparamint()
        Case $60
            local0 = (Str player[se_getparamint()]\Field35)
            local1 = $01
        Case $61
            local0 = (Str player[se_getparamint()]\Field57)
            local1 = $01
        Case $62
            local0 = (Str player[se_getparamint()]\Field32)
            local1 = $01
        Case $63
            local0 = (Str player[se_getparamint()]\Field19)
            local1 = $01
        Case $64
            local0 = (Str player[se_getparamint()]\Field37)
            local1 = $01
        Case $65
            local0 = (Str player[se_getparamint()]\Field20)
            local1 = $01
        Case local80
            local0 = (Str player[se_getparamint()]\Field18)
            local1 = $01
        Case $66
            local0 = (Str player[se_getparamint()]\Field21)
            local1 = $01
        Case $67
            local0 = (Str player[se_getparamint()]\Field25)
            local1 = $01
        Case $68
            local0 = (Str player[se_getparamint()]\Field17)
            local1 = $02
        Case $69
            For local81 = Each scriptsthread
                If (lower(local81\Field1) = lower(se_and_lua_tostringarg($00))) Then
                    If (local81\Field3 = $00) Then
                        For local59 = $02 To se_arguments_number Step $01
                            If (se_argtype(local59) <> $00) Then
                                public_addparam($00, se_and_lua_tostringarg(local59), se_argtype(local59))
                            EndIf
                        Next
                        public_update_by_func(se_findfunc(local81\Field0, lower(se_and_lua_tostringarg($01))), $01, $00, "")
                        public_clear()
                        local0 = se_getreturnvalue()
                        local1 = se_return_value\Field0
                    Else
                        For local59 = $03 To $20 Step $01
                            If (slua_is_none_or_nil(local81\Field3, local59) = $00) Then
                                public_addparam($00, slua_to_string(local81\Field3, local59), slua_type(local81\Field3, local59))
                            Else
                                Exit
                            EndIf
                        Next
                        public_update_by_func(Null, $00, local81\Field3, lower(se_and_lua_tostringarg($01)))
                        public_clear()
                        local0 = se_getreturnvalue()
                        local1 = se_return_value\Field0
                    EndIf
                    Exit
                EndIf
            Next
        Case $6A
            If (currentluastate = $00) Then
                For local59 = $01 To se_arguments_number Step $01
                    If (se_argtype(local59) <> $00) Then
                        public_addparam($00, se_and_lua_tostringarg(local59), se_argtype(local59))
                    EndIf
                Next
                public_update_by_func(se_findfunc(se_current_function\Field1, lower(se_and_lua_tostringarg($00))), $01, $00, "")
                public_clear()
                local0 = se_getreturnvalue()
                local1 = se_return_value\Field0
            Else
                For local59 = $01 To $20 Step $01
                    If (slua_is_none_or_nil(currentluastate, local59) = $00) Then
                        public_addparam($00, slua_to_string(currentluastate, local59), slua_type(currentluastate, local59))
                    Else
                        Exit
                    EndIf
                Next
                public_update_by_func(Null, $00, arg0, lower(se_and_lua_tostringarg($01)))
                public_clear()
                local0 = se_getreturnvalue()
                local1 = se_return_value\Field0
            EndIf
        Case $6B
            local0 = (Str movex)
            local1 = $02
        Case $6C
            local0 = (Str movey)
            local1 = $02
        Case $6D
            local0 = (Str movez)
            local1 = $02
        Case $6E
            local82 = createpivot($00)
            positionentity(local82, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), $00)
            rotateentity(local82, se_and_lua_tofloatarg($07), se_and_lua_tofloatarg($06), 0.0, $00)
            moveentity(local82, se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05))
            movex = entityx(local82, $00)
            movey = entityy(local82, $00)
            movez = entityz(local82, $00)
            freeentity(local82)
        Case $6F
            local0 = (Str pointyaw)
            local1 = $02
        Case $70
            local0 = (Str pointpitch)
            local1 = $02
        Case $71
            local82 = createpivot($00)
            local83 = createpivot($00)
            positionentity(local82, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), $00)
            positionentity(local83, se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05), $00)
            pointentity(local82, local83, 0.0)
            pointyaw = entityyaw(local82, $00)
            pointpitch = entitypitch(local82, $00)
            freeentity(local82)
            freeentity(local83)
        Case $72
            local0 = (Str player[se_getparamint()]\Field36)
            local1 = $01
        Case $73
            createsound(se_and_lua_tostringarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05))
        Case $74
            createplayersound(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05), se_and_lua_tofloatarg($06))
        Case $75
            local0 = (Str player[se_getparamint()]\Field62)
            local1 = $01
        Case $76
            notarget = se_getparamint()
        Case $77
            contained106 = se_getparamint()
        Case $78
            remotedooron = se_getparamint()
        Case $79
            mtftimer = se_getparamfloat()
        Case $7A
            local0 = room[se_getparamint()]\Field7\Field10
            local1 = $03
        Case $7B
            local0 = (Str room[se_getparamint()]\Field2)
            local1 = $01
        Case $7C
            local0 = (Str (room[se_getparamint()] <> Null))
            local1 = $01
        Case $198
            local0 = "0"
            local1 = $01
            If (((se_and_lua_tointarg($01) >= $00) And (se_and_lua_tointarg($01) <= $07)) <> 0) Then
                local0 = (Str (room[se_and_lua_tointarg($00)]\Field29[se_and_lua_tointarg($01)] <> Null))
            EndIf
        Case $197
            local0 = (Str room[se_and_lua_tointarg($00)]\Field29[se_and_lua_tointarg($01)]\Field18)
            local1 = $01
        Case $7D
            local84 = se_getparamint()
            local85 = se_getparamint()
            room[local84]\Field26[local85] = $00
            local0 = (Str room[local84]\Field25[local85])
            local1 = $01
        Case $7E
            local86 = se_getparamint()
            mp_door[local86]\Field5 = se_getparamint()
        Case $7F
            local86 = se_getparamint()
            mp_door[local86]\Field4 = se_getparamint()
        Case $80
            local0 = (Str mp_door[se_getparamint()]\Field0)
            local1 = $01
        Case $81
            local0 = (Str mp_door[se_getparamint()]\Field9)
            local1 = $01
        Case $82
            local0 = (Str mp_door[se_getparamint()]\Field5)
            local1 = $01
        Case $83
            local0 = (Str mp_door[se_getparamint()]\Field4)
            local1 = $01
        Case $1EC
            mp_door[se_and_lua_tointarg($00)]\Field35 = $01
            mp_door[se_and_lua_tointarg($00)]\Field12 = se_and_lua_tointarg($01)
        Case $1EE
            local0 = (Str mp_door[se_getparamint()]\Field12)
            local1 = $01
        Case $1F5
            mp_door[se_and_lua_tointarg($00)]\Field36 = $01
            mp_door[se_and_lua_tointarg($00)]\Field17 = se_and_lua_tostringarg($01)
        Case $1F4
            local0 = mp_door[se_getparamint()]\Field17
            local1 = $03
        Case $84
            local0 = (Str (mp_door[se_getparamint()] <> Null))
            local1 = $01
        Case $85
            local7 = se_getparamint()
            local87 = se_getparamint()
            For local49 = Each items
                If (local49\Field18 = local87) Then
                    local49\Field22 = local7
                    local49\Field15 = (local49\Field22 <> $00)
                    Exit
                EndIf
            Next
        Case $86
            local88 = se_getparamint()
            For local4 = Each itemtemplates
                If (local4\Field0 = local88) Then
                    local0 = local4\Field1
                    local1 = $03
                    Exit
                EndIf
            Next
        Case $87
            local88 = se_getparamint()
            For local4 = Each itemtemplates
                If (local4\Field0 = local88) Then
                    local0 = local4\Field2
                    local1 = $03
                    Exit
                EndIf
            Next
        Case $88
            local0 = (Str m_item[se_getparamint()]\Field3\Field0)
            local1 = $01
        Case $89
            local49 = Null
            local89 = se_getparamstring()
            local90 = se_getparamstring()
            For local4 = Each itemtemplates
                If (((lower(local4\Field1) = lower(local89)) And (lower(local4\Field2) = lower(local90))) <> 0) Then
                    local49 = createitem(local4\Field1, local4\Field2, 9999.0, 9999.0, 9999.0, $00, $00, $00, 1.0, $00, $01)
                    Exit
                EndIf
            Next
            If (local49 <> Null) Then
                local0 = (Str local49\Field18)
                local1 = $01
            EndIf
        Case $8A
            removeitem(m_item[se_getparamint()], $01)
        Case $8B
            local0 = (Str m_item[se_getparamint()]\Field1)
            local1 = $01
        Case $8C
            local0 = (Str m_item[se_getparamint()]\Field22)
            local1 = $01
        Case $8D
            local0 = (Str (m_item[se_getparamint()] <> Null))
            local1 = $01
        Case $8E
            local91 = se_getparamint()
            local0 = (Str (m_npc[local91] <> Null))
            local1 = $01
        Case $8F
            local92 = createnpc(se_getparamint(), 9999.0, 9999.0, 9999.0)
            If (local92 <> Null) Then
                local0 = (Str local92\Field6)
                local1 = $01
            EndIf
        Case $90
            local0 = (Str m_npc[se_getparamint()]\Field5)
            local1 = $01
        Case $91
            local0 = (Str m_npc[se_getparamint()]\Field9)
            local1 = $02
        Case $92
            local0 = (Str m_npc[se_getparamint()]\Field10)
            local1 = $02
        Case $93
            local0 = (Str m_npc[se_getparamint()]\Field11)
            local1 = $02
        Case $94
            local91 = se_getparamint()
            m_npc[local91]\Field9 = se_getparamfloat()
            m_npc[local91]\Field10 = se_getparamfloat()
            m_npc[local91]\Field11 = se_getparamfloat()
        Case $95
            local0 = (Str m_npc[se_getparamint()]\Field80)
            local1 = $01
        Case $96
            local0 = (Str m_npc[se_getparamint()]\Field4)
            local1 = $01
        Case $160
            local93 = se_getparamint()
            local0 = m_event[local93]\Field0
            local1 = $03
        Case $161
            local93 = se_getparamint()
            If (m_event[local93]\Field1 <> Null) Then
                local0 = (Str m_event[local93]\Field1\Field69)
            EndIf
            local1 = $01
        Case $97
            local94 = se_getparamstring()
            For local95 = Each events
                If (local95\Field0 = local94) Then
                    local0 = (Str local95\Field15)
                    local1 = $01
                    Exit
                EndIf
            Next
        Case $98
            local93 = se_getparamint()
            local0 = (Str m_event[local93]\Field2)
            local1 = $02
        Case $99
            local93 = se_getparamint()
            local0 = (Str m_event[local93]\Field3)
            local1 = $02
        Case $9A
            local93 = se_getparamint()
            local0 = (Str m_event[local93]\Field4)
            local1 = $02
        Case $9B
            local93 = se_getparamint()
            local0 = m_event[local93]\Field11
            local1 = $03
        Case $9C
            local93 = se_getparamint()
            local0 = (Str (m_event[local93] <> Null))
            local1 = $01
        Case $9D
            removeevent(m_event[se_getparamint()])
        Case $9E
            local93 = se_getparamint()
            m_event[local93]\Field11 = se_getparamstring()
        Case $9F
            local93 = se_getparamint()
            m_event[local93]\Field2 = se_getparamfloat()
            m_event[local93]\Field3 = se_getparamfloat()
            m_event[local93]\Field4 = se_getparamfloat()
        Case $A0
            local96 = se_getparamstring()
            local97 = rcon_findcmd(local96)
            If (local97 = "Not found") Then
                Return addtexttochat("[RCON] Command not found", local98)
            EndIf
            local99 = rcon_getattribute(local96)
            Select rcon_executecmd(local97, local99)
                Case "gravity"
                    addlog(("Gravity changed to " + local99), $00, $01, $00)
                Case "hostname"
                    addlog(("Hostname changed to " + local99), $00, $01, $00)
                Case "password"
                    addlog(("Password changed to " + local99), $00, $00, $00)
            End Select
        Case $A1
            createrocket(15.0, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), $00)
            For local59 = $01 To server\Field18 Step $01
                If (player[local59] <> Null) Then
                    If (50.0 > distance3(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), entityx(player[local59]\Field62, $00), entityy(player[local59]\Field62, $00), entityz(player[local59]\Field62, $00))) Then
                        udp_writebyte($51)
                        udp_writebyte($00)
                        udp_writeshort($00)
                        udp_writefloat(se_and_lua_tofloatarg($00))
                        udp_writefloat(se_and_lua_tofloatarg($01))
                        udp_writefloat(se_and_lua_tofloatarg($02))
                        udp_writefloat(se_and_lua_tofloatarg($03))
                        udp_writefloat(se_and_lua_tofloatarg($04))
                        udp_sendmessage(local59)
                    EndIf
                EndIf
            Next
        Case $A2
            closefile(se_getparamint())
        Case $A3
            local0 = readline(se_getparamint())
            local1 = $03
        Case $A4
            local0 = (Str readint(se_getparamint()))
            local1 = $01
        Case $A5
            local0 = (Str readfloat(se_getparamint()))
            local1 = $02
        Case $A6
            local0 = (Str readshort(se_getparamint()))
            local1 = $01
        Case $A7
            local0 = (Str readbyte(se_getparamint()))
            local1 = $01
        Case $A8
            writeline(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $A9
            writeint(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $AA
            writefloat(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01))
        Case $AB
            writeshort(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $AC
            writebyte(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $AD
            local0 = (Str openfile(se_getparamstring()))
            local1 = $01
        Case $AE
            local0 = (Str readfile(se_getparamstring()))
            local1 = $01
        Case $AF
            local31 = se_getparamstring()
            local0 = (Str writefile(local31))
            local1 = $01
        Case $B0
            secondarylighton = se_getparamfloat()
        Case $B1
            local0 = (Str secondarylighton)
            local1 = $02
        Case $B2
            mp_version = se_getparamstring()
        Case $B3
            local0 = mp_version
            local1 = $03
        Case $B4
            local0 = player[se_getparamint()]\Field54
            local1 = $03
        Case $B5
            local7 = se_getparamint()
            local101 = se_getparamint()
            If (((local101 < $00) And (local101 > $00)) <> 0) Then
                Return $00
            EndIf
            player[local7]\Field38 = ((((((readbool(player[local7]\Field38, $00) + (readbool(player[local7]\Field38, $01) Shl $01)) + (readbool(player[local7]\Field38, $02) Shl $02)) + (local101 Shl $03)) + (readbool(player[local7]\Field38, $04) Shl $04)) + (readbool(player[local7]\Field38, $05) Shl $05)) + (readbool(player[local59]\Field38, $06) Shl $06))
        Case $B6
            local0 = (Str readbool(player[se_getparamint()]\Field38, $03))
            local1 = $01
        Case $B7
            text_setpos(se_and_lua_tointarg($00), se_and_lua_tointarg($01), (Int se_and_lua_tofloatarg($02)), (Int se_and_lua_tofloatarg($03)))
        Case $B8
            text_settext(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tostringarg($02))
        Case $B9
            text_setcolor(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $BA
            draw_setcolor(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02))
        Case $BB
            draw_setpos(se_and_lua_tointarg($00), se_and_lua_tointarg($01), (Int se_and_lua_tofloatarg($02)), (Int se_and_lua_tofloatarg($03)))
        Case $BC
            local0 = (Str millisecs())
            local1 = $01
        Case $BD
            local7 = se_getparamint()
            local0 = "0"
            If (((local7 > $00) And (local7 < $41)) <> 0) Then
                local0 = (Str (player[local7] <> Null))
            EndIf
            local1 = $01
        Case $BE
            setplayerfogrange(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01))
        Case $BF
            restartserver("")
        Case $C0
            local0 = (Str player[se_getparamint()]\Field71)
            local1 = $01
        Case $C1
            local0 = (Str player[se_getparamint()]\Field72)
            local1 = $01
        Case $C2
            restartserver(se_getparamstring())
        Case $C3
            object_remove((Int se_getparamstring()))
        Case $C4
            local0 = (Str object_create(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tointarg($05), se_and_lua_tointarg($06)))
            local1 = $01
        Case $C5
            text_remove(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $C6
            local0 = (Str text_create(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), (Int se_and_lua_tofloatarg($02)), (Int se_and_lua_tofloatarg($03)), se_and_lua_tointarg($04), se_and_lua_tostringarg($05), se_and_lua_tofloatarg($06)))
            local1 = $01
        Case $C7
            draw_remove(se_and_lua_tointarg($00), se_and_lua_tointarg($01))
        Case $C8
            local0 = (Str draw_create(se_and_lua_tointarg($00), (Int se_and_lua_tofloatarg($01)), (Int se_and_lua_tofloatarg($02)), (Int se_and_lua_tofloatarg($03)), (Int se_and_lua_tofloatarg($04)), se_and_lua_tointarg($05), se_and_lua_tointarg($06), se_and_lua_tostringarg($07)))
            local1 = $01
        Case $C9
            local7 = se_getparamint()
            local102 = se_getparamint()
            setplayertype(local7, local102)
        Case $CA
            local0 = player[se_and_lua_tointarg($00)]\Field40
            local1 = $03
        Case $CB
            local7 = (Int se_getparamstring())
            local0 = (Str player[local7]\Field33)
            local1 = $01
        Case $CC
            local7 = se_and_lua_tointarg($00)
            local0 = player[local7]\Field15
            local1 = $03
        Case $CD
            shoot2(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tointarg($05))
        Case $CE
            player[se_and_lua_tointarg($00)]\Field33 = se_and_lua_tointarg($01)
        Case $CF
            local0 = (Str (player[se_getparamint()]\Field55 = $01))
            local1 = $01
        Case $D0
            local103 = createplayer(findfreeplayerid())
            If (local103 = Null) Then
                local98 = $00
            Else
                local98 = local103\Field30
                local104 = se_getparamstring()
                player[local98]\Field15 = local104
                player[local98]\Field55 = $01
                player[local98]\Field22 = $01
                player[local98]\Field38 = ((((((readbool(player[local98]\Field38, $01) Shl $01) + $01) + (readbool(player[local98]\Field38, $02) Shl $02)) + (readbool(player[local98]\Field38, $03) Shl $03)) + $00) + $20)
                player[local98]\Field25 = $01
                player[local98]\Field33 = $05
                player[local98]\Field36 = $00
                addlog((local104 + " has joined to server"), $00, $01, $00)
                mp_createplayerobject(local103\Field30)
                public_inqueue($23, $00)
                public_addparam($00, (Str local98), $01)
                callback($00)
            EndIf
            local0 = (Str local98)
            local1 = $01
        Case $D1
            local7 = se_getparamint()
            local0 = (Str player[local7]\Field58)
            local1 = $01
        Case $D2
            local7 = se_getparamint()
            local0 = (Str readbool(player[local7]\Field38, $04))
            local1 = $01
        Case $D3
            player[se_and_lua_tointarg($00)]\Field38 = (((((((readbool(player[local7]\Field38, $01) Shl $01) + $01) + (readbool(player[local7]\Field38, $02) Shl $02)) + (readbool(player[local7]\Field38, $03) Shl $03)) + (se_and_lua_tointarg($01) Shl $04)) + (readbool(player[local7]\Field38, $05) Shl $05)) + (readbool(player[local59]\Field38, $06) Shl $06))
        Case $D4
            player[se_and_lua_tointarg($00)]\Field35 = se_and_lua_tointarg($01)
        Case $D5
            player[se_and_lua_tointarg($00)]\Field19 = se_and_lua_tointarg($01)
        Case $D6
            player[se_and_lua_tointarg($00)]\Field18 = se_and_lua_tointarg($01)
        Case $D7
            player[se_and_lua_tointarg($00)]\Field21 = se_and_lua_tointarg($01)
        Case $D8
            player[se_and_lua_tointarg($00)]\Field37 = se_and_lua_tointarg($01)
        Case $D9
            player[se_and_lua_tointarg($00)]\Field20 = se_and_lua_tointarg($01)
        Case $DA
            player[se_and_lua_tointarg($00)]\Field17 = se_and_lua_tofloatarg($01)
        Case $DB
            setplayerposition(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04))
        Case $1DE
            setplayerpositionex(se_and_lua_tointarg($00), se_and_lua_tointarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04))
        Case $DC
            local7 = se_getparamint()
            local53 = se_getparamfloat()
            player[local7]\Field3 = local53
        Case $DD
            sendplayermsg(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02))
        Case $DE
            local7 = se_getparamint()
            player[local7]\Field41 = $01
            addtexttochat("[RCON] You got the admin role.", local7)
        Case $DF
            player[se_getparamint()]\Field41 = $00
        Case $E0
            local0 = (Str player[se_getparamint()]\Field41)
            local1 = $01
        Case $E1
            addtexttochat(se_getparamstring(), $00)
        Case $E2
            sendconsolecommand(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02))
        Case $E3
            playsoundforplayers(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03))
        Case $E4
            playsoundforplayer(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $E5
            addtexttochat(se_and_lua_tostringarg($01), se_and_lua_tointarg($00))
        Case $E6
            kick(se_and_lua_tointarg($00), se_and_lua_tostringarg($01))
        Case $E7
            rcon_banip("banlist", se_getparamstring())
        Case $E8
            plugin_remove(se_getparamint())
        Case $E9
            local0 = plugin_call(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02))
            local1 = $03
        Case $EA
            local0 = (Str plugin_poke(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02)))
            local1 = $01
        Case $EB
            local0 = (Str plugin_init(se_getparamstring()))
            local1 = $01
        Case $EC
            delay(se_getparamint())
        Case $ED
            addlog(se_and_lua_tostringarg($00), $00, $00, $01)
        Case $EE
            local31 = se_getparamstring()
            local105 = se_getparamstring()
            local106 = se_getparamstring()
            local107 = se_getparamstring()
            local1 = $03
            local0 = getinistring(local31, local105, local106, local107)
        Case $EF
            local31 = se_getparamstring()
            local105 = se_getparamstring()
            local106 = se_getparamstring()
            local107 = se_getparamstring()
            putinivalue(local31, local105, local106, local107)
        Case $F1
            updateinifile(se_getparamstring())
        Case $F0
            local0 = (Str getunixtimestamp())
            local1 = $01
        Case $1F2
            local0 = currenttime()
            local1 = $03
        Case $1F3
            local0 = currentdate()
            local1 = $03
        Case $F2
            se_and_lua_returnint(se_and_lua_tointarg($00))
            Return $00
        Case $F3
            se_and_lua_returnfloat(se_and_lua_tofloatarg($00))
            Return $00
        Case $F4
            se_and_lua_returnstring((Str se_and_lua_tofloatarg($00)))
            Return $00
        Case $F5
            se_and_lua_returnfloat(floor(se_and_lua_tofloatarg($00)))
            Return $00
        Case $F6
            se_and_lua_returnfloat(ceil(se_and_lua_tofloatarg($00)))
            Return $00
        Case $F7
            se_and_lua_returnint((Sgn se_and_lua_tointarg($00)))
            Return $00
        Case $F8
            se_and_lua_returnint((Abs se_intarg($00, $00)))
            Return $00
        Case $F9
            se_and_lua_returnfloat(sqr(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FA
            se_and_lua_returnfloat(sin(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FB
            se_and_lua_returnfloat(cos(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FC
            se_and_lua_returnfloat(tan(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FD
            se_and_lua_returnfloat(asin(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FE
            se_and_lua_returnfloat(acos(se_and_lua_tofloatarg($00)))
            Return $00
        Case $FF
            se_and_lua_returnfloat(atan(se_and_lua_tofloatarg($00)))
            Return $00
        Case $100
            se_and_lua_returnfloat(atan2(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01)))
            Return $00
        Case $101
            se_and_lua_returnfloat(exp(se_and_lua_tofloatarg($00)))
            Return $00
        Case $102
            se_and_lua_returnfloat(log(se_and_lua_tofloatarg($00)))
            Return $00
        Case $103
            se_and_lua_returnfloat(log10(se_and_lua_tofloatarg($00)))
            Return $00
        Case $104
            se_and_lua_returnfloat(rnd(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01)))
            Return $00
        Case $105
            se_and_lua_returnint(rand(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            Return $00
        Case $106
            se_and_lua_returnstring(se_and_lua_tostringarg($00))
            Return $00
        Case $107
            se_and_lua_returnstring(left(se_and_lua_tostringarg($00), se_and_lua_tointarg($01)))
            Return $00
        Case $108
            se_and_lua_returnstring(right(se_and_lua_tostringarg($00), se_and_lua_tointarg($01)))
            Return $00
        Case $109
            se_and_lua_returnstring(mid(se_and_lua_tostringarg($00), se_and_lua_tointarg($01), se_and_lua_tointarg($02)))
            Return $00
        Case $10A
            se_and_lua_returnstring(replace(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02)))
            Return $00
        Case $10B
            se_and_lua_returnint(instr(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02)))
            Return $00
        Case $10C
            se_and_lua_returnstring(lower(se_and_lua_tostringarg($00)))
            Return $00
        Case $10D
            se_and_lua_returnstring(upper(se_and_lua_tostringarg($00)))
            Return $00
        Case $10E
            se_and_lua_returnstring(trim(se_and_lua_tostringarg($00)))
            Return $00
        Case $112
            se_and_lua_returnstring(hex(se_and_lua_tointarg($00)))
            Return $00
        Case $113
            se_and_lua_returnstring(bin(se_and_lua_tointarg($00)))
            Return $00
        Case $114
            se_and_lua_returnstring(string(se_and_lua_tostringarg($00), se_and_lua_tointarg($01)))
            Return $00
        Case $115
            se_bl_array_create()
        Case $116
            se_bl_array_push()
        Case $117
            se_bl_array_pop()
        Case $118
            se_bl_array_delete()
        Case $119
            se_bl_array_sort()
        Case $11A
            se_bl_array_fromstring()
        Case $11B
            local7 = se_getparamint()
            local104 = se_getparamstring()
            changeplayernickname(local7, local104)
        Case $11C
            local7 = se_getparamint()
            local14 = se_getparamstring()
            local108 = se_getparamint()
            local109 = se_getparamint()
            local110 = se_getparamint()
            changeplayertag(local7, local14, local108, local109, local110)
        Case $11D
            local0 = (Str (player[se_getparamint()]\Field157 = "PATRON"))
            local1 = $01
        Case $11E
            local0 = incomingversion
            local1 = $03
        Case $11F
            local0 = (Str incomingpatron)
            local1 = $01
        Case $120
            gameinfo\Field5\Field9 = se_getparamfloat()
        Case $121
            gameinfo\Field5\Field10 = se_getparamfloat()
        Case $122
            local0 = (Str gameinfo\Field5\Field9)
            local1 = $02
        Case $123
            local0 = (Str gameinfo\Field5\Field10)
            local1 = $02
        Case $124
            server\Field64 = se_getparamint()
        Case $15E
            local0 = (Str player[local111]\Field139)
            local1 = $01
        Case $15D
            local7 = se_getparamint()
            player[local7]\Field139 = se_getparamint()
        Case $126
            server\Field65 = se_getparamint()
    End Select
    Select local1
        Case $01
            se_and_lua_returnint((Int local0))
        Case $02
            se_and_lua_returnfloat((Float local0))
        Case $03
            se_and_lua_returnstring(local0)
        Default
            se_and_lua_returnint($00)
    End Select
    Return $00
End Function
