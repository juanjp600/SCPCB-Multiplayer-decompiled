Function se_executefunction%(arg0%, arg1%)
    Local local0$
    Local local1%
    Local local3%
    Local local4.itemtemplates
    Local local5.events
    Local local6.querys
    Local local7%
    Local local8.spawnpoint
    Local local9%
    Local local10$
    Local local11%
    Local local12%
    Local local13%
    Local local14.steaminstances
    Local local15%
    Local local16$
    Local local17$
    Local local18%
    Local local19$
    Local local20$
    Local local21$
    Local local22%
    Local local23%
    Local local24$
    Local local25%
    Local local26$
    Local local27%
    Local local28$
    Local local29%
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    Local local34%
    Local local35$
    Local local36%
    Local local37%
    Local local38%
    Local local39$
    Local local40$
    Local local41%
    Local local42%
    Local local43%
    Local local44$
    Local local45$
    Local local46.items
    Local local47%
    Local local48#
    Local local49#
    Local local50#
    Local local51%
    Local local52$
    Local local53%
    Local local54%
    Local local55$
    Local local56%
    Local local57$
    Local local58%
    Local local59%
    Local local60.bs
    Local local61$
    Local local63%
    Local local64%
    Local local65$
    Local local66%
    Local local67%
    Local local68%
    Local local69%
    Local local70%
    Local local71%
    Local local72%
    Local local73%
    Local local74%
    Local local75%
    Local local76%
    Local local77.scriptsthread
    Local local78%
    Local local79%
    Local local80%
    Local local81%
    Local local82%
    Local local83%
    Local local84%
    Local local85$
    Local local86$
    Local local87%
    Local local88.npcs
    Local local89%
    Local local90$
    Local local91.events
    Local local92$
    Local local93$
    Local local94%
    Local local95$
    Local local97%
    Local local98%
    Local local99.players
    Local local100$
    Local local101$
    Local local102$
    Local local103$
    Local local104%
    Local local105%
    Local local106%
    Local local107%
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
            addlog(((("Detected error #" + (Str se_and_lua_tointarg($00))) + ": ") + se_and_lua_tostringarg($01)), $00, $00, $00, $C0, $C0, $C0)
        Case $1FD
            local4 = createitemtemplate(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tostringarg($02), se_and_lua_tostringarg($03), se_and_lua_tostringarg($04), se_and_lua_tofloatarg($05), "", "", $00, $09, $00)
            local4\Field3 = se_and_lua_tointarg($06)
            local0 = (Str local4\Field0)
            local1 = $01
        Case $1F7
            server\Field77 = ($01 - se_getparamint())
        Case $1F8
            server\Field75 = se_getparamint()
        Case $1F9
            server\Field76 = se_getparamint()
        Case $1FA
            player[se_and_lua_tointarg($00)]\Field122 = se_and_lua_tointarg($01)
        Case $1FB
            player[se_and_lua_tointarg($00)]\Field124 = se_and_lua_tointarg($01)
        Case $1FC
            player[se_and_lua_tointarg($00)]\Field123 = se_and_lua_tointarg($01)
        Case $1FC
            local0 = (Str (player[se_and_lua_tointarg($01)]\Field122 = $01))
            local1 = $01
        Case $1EF
            local5 = createevent(se_and_lua_tostringarg($00), se_and_lua_tostringarg($01), se_and_lua_tointarg($02), se_and_lua_tofloatarg($03))
            If (local5 <> Null) Then
                local0 = (Str local5\Field15)
            EndIf
            local1 = $01
        Case $1ED
            local0 = (Str player[se_and_lua_tointarg($00)]\Field58)
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
            local0 = (Str player[se_getparamint()]\Field176)
            local1 = $02
        Case $1E0
            player[se_and_lua_tointarg($00)]\Field176 = se_and_lua_tofloatarg($01)
        Case $1E2
            player[se_and_lua_tointarg($00)]\Field96 = se_and_lua_tointarg($01)
        Case $1E3
            local0 = (Str player[se_getparamint()]\Field96)
            local1 = $01
        Case $1DF
            turnentity(se_and_lua_tointarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tointarg($04))
        Case $1DC
            object_sound_create(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), $00)
        Case $1DD
            object_sound_create(se_and_lua_tointarg($01), se_and_lua_tostringarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tointarg($00))
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
            server\Field70 = se_getparamint()
        Case $1C4
            server\Field71 = se_getparamint()
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
            local0 = (Str player[se_and_lua_tointarg($00)]\Field71)
            local1 = $01
        Case $1BA
            local0 = (Str entitydistance(se_and_lua_tointarg($00), se_and_lua_tointarg($01)))
            local1 = $02
        Case $1B9
            local0 = (Str player[se_and_lua_tointarg($00)]\Field70)
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
            player[se_and_lua_tointarg($00)]\Field165 = se_and_lua_tointarg($01)
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
        Case $166
            local9 = se_getparamint()
            local10 = se_getparamstring()
            local11 = se_getparamint()
            local12 = se_getparamint()
            local13 = se_getparamint()
            createsteaminstance(local9, local10, local11, local12, local13, $00)
        Case $168
            local9 = se_getparamint()
            For local14 = Each steaminstances
                If (local14\Field0 = local9) Then
                    Delete local14
                EndIf
            Next
        Case $167
            local0 = ""
            local1 = $03
            local9 = se_getparamint()
            For local14 = Each steaminstances
                If (local14\Field0 = local9) Then
                    local0 = local14\Field1
                    Exit
                EndIf
            Next
        Case $164
            local15 = se_getparamint()
            local16 = se_getparamstring()
            server\Field60[local15] = local16
        Case $165
            local0 = server\Field60[se_getparamint()]
            local1 = $01
        Case $163
            server\Field65 = se_getparamint()
        Case $162
            local0 = (Str server\Field65)
            local1 = $01
        Case $15F
            server\Field64 = se_getparamint()
        Case $15C
            end()
        Case $151
            local17 = se_getparamstring()
            local18 = se_getparamint()
            local19 = se_getparamstring()
            local20 = se_getparamstring()
            local21 = se_getparamstring()
            local22 = se_getparamint()
            local0 = (Str opensqlstream(local17, local18, local19, local20, local21, local22))
            local1 = $01
        Case $152
            local0 = (Str sqlconnected(se_getparamint()))
            local1 = $01
        Case $153
            local23 = se_getparamint()
            local24 = se_getparamstring()
            local0 = (Str sqlquery(local23, local24))
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
            local25 = se_getparamint()
            local26 = se_getparamstring()
            local0 = readsqlfield(local25, local26)
            local1 = $03
        Case $158
            local25 = se_getparamint()
            local27 = se_getparamint()
            local0 = readsqlfieldindex(local25, local27)
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
            local28 = se_getparamstring()
            local29 = se_getparamint()
            local30 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str opendatabase(local28, local29, local30, local31))
            local1 = $01
        Case $12B
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str closedatabase(local32, local31))
            local1 = $01
        Case $12C
            local33 = se_getparamint()
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str setdatabasetimeout(local33, local32, local31))
            local1 = $01
        Case $12D
            local0 = databaseversion()
            local1 = $03
        Case $12E
            local32 = se_getparamint()
            local0 = (Str lastrowidinserted(local32))
            local1 = $01
        Case $12F
            local32 = se_getparamint()
            local0 = (Str rowschangedbylaststatement(local32))
            local1 = $01
        Case $130
            local32 = se_getparamint()
            local0 = (Str rowschangedthissession(local32))
            local1 = $01
        Case $131
            local32 = se_getparamint()
            local0 = (Str autocommitison(local32))
            local1 = $01
        Case $132
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str begintransaction(local32, local31))
            local1 = $01
        Case $133
            local34 = se_getparamint()
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str committransaction(local34, local32, local31))
            local1 = $01
        Case $134
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str rollbacktransaction(local32, local31))
            local1 = $01
        Case $135
            local32 = se_getparamint()
            local0 = (Str lastdatabaseerrorcode(local32))
            local1 = $01
        Case $136
            local32 = se_getparamint()
            local0 = lastdatabaseerrormessage(local32)
            local1 = $03
        Case $137
            local32 = se_getparamint()
            local0 = (Str interruptdatabase(local32))
            local1 = $01
        Case $138
            local35 = se_getparamstring()
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str executesql(local35, local32, local31))
            local1 = $01
        Case $139
            local35 = se_getparamstring()
            local32 = se_getparamint()
            local30 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str preparesql(local35, local32, local30, local31))
            local1 = $01
        Case $13A
            local32 = se_getparamint()
            local36 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str getnextdatarow(local32, local36, local31))
            local1 = $01
        Case $13B
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str finalisesql(local32, local31))
            local1 = $01
        Case $13C
            local32 = se_getparamint()
            local31 = se_getparamint()
            local0 = (Str resetsql(local32, local31))
            local1 = $01
        Case $13D
            local32 = se_getparamint()
            local0 = (Str sqlhasexpired(local32))
            local1 = $01
        Case $13E
            local32 = se_getparamint()
            local0 = (Str getdatabasehandlefromstatementhandle(local32))
            local1 = $01
        Case $13F
            local32 = se_getparamint()
            local0 = (Str getcolumncount(local32))
            local1 = $01
        Case $140
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = getcolumnname(local37, local32)
            local1 = $03
        Case $141
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str getcolumntype(local37, local32))
            local1 = $01
        Case $142
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = getcolumndeclaredtype(local37, local32)
            local1 = $03
        Case $143
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str getcolumnsize(local37, local32))
            local1 = $01
        Case $144
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str getcolumnvalueasinteger(local37, local32))
            local1 = $01
        Case $145
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str getcolumnvalueasfloat(local37, local32))
            local1 = $02
        Case $146
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = getcolumnvalueasstring(local37, local32)
            local1 = $03
        Case $147
            local37 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str getcolumnvalueasblob(local37, local32))
            local1 = $01
        Case $148
            local32 = se_getparamint()
            local0 = (Str sqlparametercount(local32))
            local1 = $01
        Case $149
            local38 = se_getparamint()
            local32 = se_getparamint()
            local0 = sqlparametername(local38, local32)
            local1 = $03
        Case $14A
            local39 = se_getparamstring()
            local32 = se_getparamint()
            local0 = (Str sqlparameterindex(local39, local32))
            local1 = $01
        Case $14B
            local38 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str bindsqlparameterasnull(local38, local32))
            local1 = $01
        Case $14C
            local38 = se_getparamint()
            local40 = (Str se_getparamint())
            local32 = se_getparamint()
            local0 = (Str bindsqlparameterasinteger(local38, (Int local40), local32))
            local1 = $01
        Case $14D
            local38 = se_getparamint()
            local40 = (Str se_getparamfloat())
            local32 = se_getparamint()
            local0 = (Str bindsqlparameterasfloat(local38, (Float local40), local32))
            local1 = $01
        Case $14E
            local38 = se_getparamint()
            local40 = se_getparamstring()
            local32 = se_getparamint()
            local0 = (Str bindsqlparameterasstring(local38, local40, local32))
            local1 = $01
        Case $14F
            local38 = se_getparamint()
            local41 = se_getparamint()
            local42 = se_getparamint()
            local32 = se_getparamint()
            local0 = (Str bindsqlparameterasblob(local38, local41, local42, local32))
            local1 = $01
        Case $150
            local32 = se_getparamint()
            local43 = se_getparamint()
            local0 = (Str transfersqlbindings(local32, local43))
            local1 = $01
        Case $150
            local44 = se_getparamstring()
            local31 = se_getparamint()
            local45 = se_getparamstring()
            local0 = (Str sqlite3_errorhasoccurred(local44, local31, local45))
            local1 = $01
        Case $01
            player[se_and_lua_tointarg($00)]\Field86 = se_and_lua_tofloatarg($01)
        Case $02
            local0 = (Str player[se_getparamint()]\Field86)
            local1 = $02
        Case $1F1
            local0 = (Str player[se_getparamint()]\Field141)
            local1 = $01
        Case $03
            local7 = se_getparamint()
            player[local7]\Field141 = se_getparamint()
            If (player[local7]\Field141 <> 0) Then
                For local46 = Each items
                    If (local46\Field22 = local7) Then
                        playerdropitem(local46)
                    EndIf
                Next
            EndIf
        Case $04
            local0 = (Str player[se_getparamint()]\Field131)
            local1 = $01
        Case $05
            local7 = se_getparamint()
            giveplayerhealth(local7, (Float se_getparamint()), "")
        Case $06
            local7 = se_getparamint()
            player[local7]\Field120 = se_getparamfloat()
        Case $19E
            local0 = (Str player[se_and_lua_tointarg($00)]\Field120)
            local1 = $02
        Case $07
            local7 = se_getparamint()
            mp_sendblinktimer(local7, (Int se_getparamfloat()))
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
            spawnwave()
        Case $1F0
            gameinfo\Field5\Field8 = $01
            spawnwave()
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
            local0 = (Str player[se_getparamint()]\Field63)
            local1 = $02
        Case $11
            local7 = se_getparamint()
            player[local7]\Field63 = se_getparamfloat()
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
            local47 = se_getparamint()
            local0 = (Str entityinview(local47, se_getparamint()))
            local1 = $01
        Case $16
            local47 = se_getparamint()
            local0 = (Str entityvisible(local47, se_getparamint()))
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
            local47 = se_getparamint()
            local0 = (Str entitypick(local47, se_getparamfloat()))
            local1 = $01
        Case $1E
            local47 = se_getparamint()
            local48 = se_getparamfloat()
            local49 = se_getparamfloat()
            local50 = se_getparamfloat()
            positionentity(local47, local48, local49, local50, se_getparamint())
        Case $1F
            local47 = se_getparamint()
            local48 = se_getparamfloat()
            local49 = se_getparamfloat()
            local50 = se_getparamfloat()
            rotateentity(local47, local48, local49, local50, se_getparamint())
        Case $20
            If (se_and_lua_tointarg($04) = $00) Then
                local47 = se_getparamint()
                local48 = se_getparamfloat()
                local49 = se_getparamfloat()
                local50 = se_getparamfloat()
                moveentity(local47, local48, local49, local50)
            Else
                local47 = se_getparamint()
                local48 = se_getparamfloat()
                local49 = se_getparamfloat()
                local50 = se_getparamfloat()
                translateentity(local47, local48, local49, local50, $00)
            EndIf
        Case $21
            local47 = se_getparamint()
            local48 = se_getparamfloat()
            scaleentity(local47, local48, local48, local48, $00)
        Case $22
            local47 = se_getparamint()
            entitytype(local47, (se_getparamint() Shl $01), $00)
        Case $23
            freeentity(se_getparamint())
        Case $24
            local47 = se_getparamint()
            local48 = se_getparamfloat()
            setanimtime(local47, local48, $00)
        Case $25
            local0 = (Str fpsfactor)
            local1 = $02
        Case $26
            local7 = se_getparamint()
            local51 = se_getparamint()
            If (player[local7] <> Null) Then
                udp_writebyte($72)
                udp_writebyte($01)
                udp_writebytes(local51, $00, banksize(local51))
                udp_sendmessage(local7)
            EndIf
        Case $27
            local7 = se_getparamint()
            local28 = se_getparamstring()
            local52 = se_getparamstring()
            sendfile(local7, local28, local52, $01, $00, $00)
        Case $28
            local7 = se_getparamint()
            local28 = se_getparamstring()
            local52 = se_getparamstring()
            sendfile(local7, local28, local52, $00, se_and_lua_tointarg($03), se_and_lua_tointarg($04))
        Case $29
            server\Field43 = se_getparamstring()
            addlog(("Game state changed to " + server\Field43), $00, $00, $00, $C0, $C0, $C0)
        Case $2A
            server\Field5 = serversafetext(se_getparamstring(), $40)
            addlog(("Server name changed to " + server\Field5), $00, $00, $00, $C0, $C0, $C0)
        Case $2B
            server\Field42 = se_getparamstring()
            addlog(("Description changed to " + server\Field42), $00, $00, $00, $C0, $C0, $C0)
        Case $2C
            rcon_password(se_getparamstring())
            addlog(("Password changed to " + server\Field14), $00, $00, $00, $C0, $C0, $C0)
        Case $2D
            gameinfo\Field5\Field1 = (millisecs() + se_getparamint())
            addlog(("Breach timer changed to " + (Str (gameinfo\Field5\Field1 - millisecs()))), $00, $00, $00, $C0, $C0, $C0)
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
            addlog(("No cheat changed to " + (Str server\Field2)), $00, $00, $00, $C0, $C0, $C0)
        Case $2F
            local0 = (Str player[se_getparamint()]\Field62)
            local1 = $01
        Case $30
            local7 = se_getparamint()
            local53 = se_getparamint()
            player[local7]\Field62 = (Float local53)
        Case $31
            server\Field41 = (server\Field41 = $00)
        Case $32
            reloadapplication()
        Case $33
            local55 = se_getparamstring()
            For local56 = $01 To len(local55) Step $01
                local54 = (local54 + (asc(mid(local55, local56, $01)) Shl ((local56 - $01) Shl $03)))
            Next
            local0 = (Str local54)
            local1 = $01
        Case $34
            removetimer((Object.timers se_getparamint()))
        Case $35
            local57 = se_getparamstring()
            local58 = se_getparamint()
            local59 = se_getparamint()
            local60 = createbytestream($174)
            If (currentluastate = $00) Then
                For local56 = $03 To (se_arguments_number - $01) Step $01
                    If (se_argtype(local56) <> $00) Then
                        Select se_argtype(local56)
                            Case $01
                                local61 = (local61 + "i")
                                bytestreamwriteint(local60, se_and_lua_tointarg(local56))
                            Case $02
                                local61 = (local61 + "f")
                                bytestreamwritefloat(local60, se_and_lua_tofloatarg(local56))
                            Case $03
                                local61 = (local61 + "s")
                                bytestreamwritestring(local60, se_and_lua_tostringarg(local56))
                        End Select
                    EndIf
                Next
                local0 = (Str settimer(se_current_function\Field1, local57, local58, local59, local61, local60, $00))
            Else
                For local56 = $04 To $20 Step $01
                    If (slua_is_none_or_nil(currentluastate, local56) = $00) Then
                        If (slua_is_integer(currentluastate, local56) <> 0) Then
                            local61 = (local61 + "i")
                            bytestreamwriteint(local60, slua_to_integer(currentluastate, local56))
                        ElseIf (slua_is_number(currentluastate, local56) <> 0) Then
                            local61 = (local61 + "f")
                            bytestreamwritefloat(local60, slua_to_number(currentluastate, local56))
                        ElseIf (slua_is_string(currentluastate, local56) <> 0) Then
                            local61 = (local61 + "s")
                            bytestreamwritestring(local60, slua_to_string(currentluastate, local56))
                        EndIf
                    Else
                        Exit
                    EndIf
                Next
                local0 = (Str settimer(Null, local57, local58, local59, local61, local60, currentluastate))
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
            local63 = se_getparamint()
            local64 = se_getparamint()
            seekfile(local63, local64)
        Case $41
            local0 = (Str filepos(se_getparamint()))
            local1 = $01
        Case $42
        Case $1F6
            adderrorlog(se_and_lua_tostringarg($00))
        Case $43
            local65 = se_getparamstring()
            If (local65 = "voice") Then
                local0 = "29"
            EndIf
            local1 = $01
        Case $44
            local7 = se_getparamint()
            local66 = se_getparamint()
            local67 = se_getparamint()
            local68 = se_getparamint()
            local69 = se_getparamint()
            local70 = local66
            If (local70 <> $1D) Then
                local1 = $01
                local0 = "0"
            Else
                udp_writebyte(local66)
                udp_writebytes(getbytestreamdata(scriptbstream), $00, getbytestreamdatasize(scriptbstream))
                udp_writebytes(local67, local68, local69)
                udp_sendmessage(local7)
                local1 = $01
                local0 = "1"
                bytestreamreset(scriptbstream)
            EndIf
        Case $45
            local51 = se_getparamint()
            local71 = se_getparamint()
            local68 = se_getparamint()
            local69 = se_getparamint()
            local0 = (Str writebytes(local51, local71, local68, local69))
            local1 = $01
        Case $46
            local51 = se_getparamint()
            local71 = se_getparamint()
            local68 = se_getparamint()
            local69 = se_getparamint()
            local0 = (Str readbytes(local51, local71, local68, local69))
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
            local72 = se_getparamint()
            local69 = se_getparamint()
            resizebank(local72, local69)
        Case $4B
            local72 = se_getparamint()
            local73 = se_getparamint()
            local74 = se_getparamint()
            local75 = se_getparamint()
            local69 = se_getparamint()
            copybank(local72, local73, local74, local75, local69)
        Case $4C
            local51 = se_getparamint()
            local68 = se_getparamint()
            local0 = (Str peekbyte(local51, local68))
            local1 = $01
        Case $4D
            local51 = se_getparamint()
            local68 = se_getparamint()
            local0 = (Str peekshort(local51, local68))
            local1 = $01
        Case $4E
            local51 = se_getparamint()
            local68 = se_getparamint()
            local0 = (Str peekint(local51, local68))
            local1 = $01
        Case $4F
            local51 = se_getparamint()
            local68 = se_getparamint()
            local0 = (Str peekfloat(local51, local68))
            local1 = $02
        Case $50
            local51 = se_getparamint()
            local68 = se_getparamint()
            local76 = se_getparamint()
            pokebyte(local51, local68, local76)
        Case $51
            local51 = se_getparamint()
            local68 = se_getparamint()
            local76 = se_getparamint()
            pokeshort(local51, local68, local76)
        Case $52
            local51 = se_getparamint()
            local68 = se_getparamint()
            local76 = se_getparamint()
            pokeint(local51, local68, local76)
        Case $53
            local51 = se_getparamint()
            local68 = se_getparamint()
            local76 = (Int se_getparamfloat())
            pokefloat(local51, local68, (Float local76))
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
            player[local7]\Field59 = se_getparamint()
        Case $60
            local0 = (Str player[se_getparamint()]\Field35)
            local1 = $01
        Case $61
            local0 = (Str player[se_getparamint()]\Field59)
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
        Case $10F
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
            For local77 = Each scriptsthread
                If (lower(local77\Field1) = lower(se_and_lua_tostringarg($00))) Then
                    If (local77\Field3 = $00) Then
                        For local56 = $02 To se_arguments_number Step $01
                            If (se_argtype(local56) <> $00) Then
                                public_addparam($00, se_and_lua_tostringarg(local56), se_argtype(local56))
                            EndIf
                        Next
                        public_update_by_func(se_findfunc(local77\Field0, lower(se_and_lua_tostringarg($01))), $01, $00, "")
                        public_clear()
                        local0 = se_getreturnvalue()
                        local1 = se_return_value\Field0
                    Else
                        For local56 = $03 To $20 Step $01
                            If (slua_is_none_or_nil(local77\Field3, local56) = $00) Then
                                public_addparam($00, slua_to_string(local77\Field3, local56), slua_type(local77\Field3, local56))
                            Else
                                Exit
                            EndIf
                        Next
                        public_update_by_func(Null, $00, local77\Field3, lower(se_and_lua_tostringarg($01)))
                        public_clear()
                        local0 = se_getreturnvalue()
                        local1 = se_return_value\Field0
                    EndIf
                    Exit
                EndIf
            Next
        Case $6A
            If (currentluastate = $00) Then
                For local56 = $01 To se_arguments_number Step $01
                    If (se_argtype(local56) <> $00) Then
                        public_addparam($00, se_and_lua_tostringarg(local56), se_argtype(local56))
                    EndIf
                Next
                public_update_by_func(se_findfunc(se_current_function\Field1, lower(se_and_lua_tostringarg($00))), $01, $00, "")
                public_clear()
                local0 = se_getreturnvalue()
                local1 = se_return_value\Field0
            Else
                For local56 = $01 To $20 Step $01
                    If (slua_is_none_or_nil(currentluastate, local56) = $00) Then
                        public_addparam($00, slua_to_string(currentluastate, local56), slua_type(currentluastate, local56))
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
            local78 = createpivot($00)
            positionentity(local78, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), $00)
            rotateentity(local78, se_and_lua_tofloatarg($07), se_and_lua_tofloatarg($06), 0.0, $00)
            moveentity(local78, se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05))
            movex = entityx(local78, $00)
            movey = entityy(local78, $00)
            movez = entityz(local78, $00)
            freeentity(local78)
        Case $6F
            local0 = (Str pointyaw)
            local1 = $02
        Case $70
            local0 = (Str pointpitch)
            local1 = $02
        Case $71
            local78 = createpivot($00)
            local79 = createpivot($00)
            positionentity(local78, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), $00)
            positionentity(local79, se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05), $00)
            pointentity(local78, local79, 0.0)
            pointyaw = entityyaw(local78, $00)
            pointpitch = entitypitch(local78, $00)
            freeentity(local78)
            freeentity(local79)
        Case $72
            local0 = (Str player[se_getparamint()]\Field36)
            local1 = $01
        Case $73
            createsound(se_and_lua_tostringarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05))
        Case $74
            createplayersound(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), se_and_lua_tofloatarg($05), se_and_lua_tofloatarg($06))
        Case $75
            local0 = (Str player[se_getparamint()]\Field64)
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
            local80 = se_getparamint()
            local81 = se_getparamint()
            room[local80]\Field26[local81] = $00
            local0 = (Str room[local80]\Field25[local81])
            local1 = $01
        Case $7E
            local82 = se_getparamint()
            mp_door[local82]\Field5 = se_getparamint()
        Case $7F
            local82 = se_getparamint()
            mp_door[local82]\Field4 = se_getparamint()
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
            local83 = se_getparamint()
            For local46 = Each items
                If (local46\Field18 = local83) Then
                    local46\Field22 = local7
                    local46\Field15 = (local46\Field22 <> $00)
                    Exit
                EndIf
            Next
        Case $86
            local84 = se_getparamint()
            For local4 = Each itemtemplates
                If (local4\Field0 = local84) Then
                    local0 = local4\Field1
                    local1 = $03
                    Exit
                EndIf
            Next
        Case $87
            local84 = se_getparamint()
            For local4 = Each itemtemplates
                If (local4\Field0 = local84) Then
                    local0 = local4\Field2
                    local1 = $03
                    Exit
                EndIf
            Next
        Case $88
            local0 = (Str m_item[se_getparamint()]\Field3\Field0)
            local1 = $01
        Case $89
            local46 = Null
            local85 = se_getparamstring()
            local86 = se_getparamstring()
            For local4 = Each itemtemplates
                If (((lower(local4\Field1) = lower(local85)) And (lower(local4\Field2) = lower(local86))) <> 0) Then
                    local46 = createitem(local4\Field1, local4\Field2, 9999.0, 9999.0, 9999.0, $00, $00, $00, 1.0, $00, $01)
                    Exit
                EndIf
            Next
            If (local46 <> Null) Then
                local0 = (Str local46\Field18)
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
            local87 = se_getparamint()
            local0 = (Str (m_npc[local87] <> Null))
            local1 = $01
        Case $8F
            local88 = createnpc(se_getparamint(), 9999.0, 9999.0, 9999.0)
            If (local88 <> Null) Then
                local0 = (Str local88\Field6)
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
            local87 = se_getparamint()
            m_npc[local87]\Field9 = se_getparamfloat()
            m_npc[local87]\Field10 = se_getparamfloat()
            m_npc[local87]\Field11 = se_getparamfloat()
        Case $95
            local0 = (Str m_npc[se_getparamint()]\Field80)
            local1 = $01
        Case $96
            local0 = (Str m_npc[se_getparamint()]\Field4)
            local1 = $01
        Case $160
            local89 = se_getparamint()
            local0 = m_event[local89]\Field0
            local1 = $03
        Case $161
            local89 = se_getparamint()
            If (m_event[local89]\Field1 <> Null) Then
                local0 = (Str m_event[local89]\Field1\Field69)
            EndIf
            local1 = $01
        Case $97
            local90 = se_getparamstring()
            For local91 = Each events
                If (local91\Field0 = local90) Then
                    local0 = (Str local91\Field15)
                    local1 = $01
                    Exit
                EndIf
            Next
        Case $98
            local89 = se_getparamint()
            local0 = (Str m_event[local89]\Field2)
            local1 = $02
        Case $99
            local89 = se_getparamint()
            local0 = (Str m_event[local89]\Field3)
            local1 = $02
        Case $9A
            local89 = se_getparamint()
            local0 = (Str m_event[local89]\Field4)
            local1 = $02
        Case $9B
            local89 = se_getparamint()
            local0 = m_event[local89]\Field11
            local1 = $03
        Case $9C
            local89 = se_getparamint()
            local0 = (Str (m_event[local89] <> Null))
            local1 = $01
        Case $9D
            removeevent(m_event[se_getparamint()])
        Case $9E
            local89 = se_getparamint()
            m_event[local89]\Field11 = se_getparamstring()
        Case $9F
            local89 = se_getparamint()
            m_event[local89]\Field2 = se_getparamfloat()
            m_event[local89]\Field3 = se_getparamfloat()
            m_event[local89]\Field4 = se_getparamfloat()
        Case $A0
            local92 = se_getparamstring()
            local93 = rcon_findcmd(local92)
            If (local93 = "Not found") Then
                Return addtexttochat("[RCON] Command not found", local94)
            EndIf
            local95 = rcon_getattribute(local92)
            Select rcon_executecmd(local93, local95)
                Case "gravity"
                    addlog(("Gravity changed to " + local95), $00, $01, $00, $C0, $C0, $C0)
                Case "hostname"
                    addlog(("Hostname changed to " + local95), $00, $01, $00, $C0, $C0, $C0)
                Case "password"
                    addlog(("Password changed to " + local95), $00, $00, $00, $C0, $C0, $C0)
            End Select
        Case $A1
            createrocket(15.0, se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), se_and_lua_tofloatarg($03), se_and_lua_tofloatarg($04), $00)
            For local56 = $01 To server\Field18 Step $01
                If (player[local56] <> Null) Then
                    If (50.0 > distance3(se_and_lua_tofloatarg($00), se_and_lua_tofloatarg($01), se_and_lua_tofloatarg($02), entityx(player[local56]\Field64, $00), entityy(player[local56]\Field64, $00), entityz(player[local56]\Field64, $00))) Then
                        udp_writebyte($51)
                        udp_writebyte($00)
                        udp_writeshort($00)
                        udp_writefloat(se_and_lua_tofloatarg($00))
                        udp_writefloat(se_and_lua_tofloatarg($01))
                        udp_writefloat(se_and_lua_tofloatarg($02))
                        udp_writefloat(se_and_lua_tofloatarg($03))
                        udp_writefloat(se_and_lua_tofloatarg($04))
                        udp_sendmessage(local56)
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
            local28 = se_getparamstring()
            local0 = (Str writefile(local28))
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
            local0 = player[se_getparamint()]\Field56
            local1 = $03
        Case $B5
            local7 = se_getparamint()
            local97 = se_getparamint()
            If (((local97 < $00) And (local97 > $00)) <> 0) Then
                Return $00
            EndIf
            player[local7]\Field38 = ((((((readbool(player[local7]\Field38, $00) + (readbool(player[local7]\Field38, $01) Shl $01)) + (readbool(player[local7]\Field38, $02) Shl $02)) + (local97 Shl $03)) + (readbool(player[local7]\Field38, $04) Shl $04)) + (readbool(player[local7]\Field38, $05) Shl $05)) + (readbool(player[local56]\Field38, $06) Shl $06))
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
            local0 = (Str player[se_getparamint()]\Field73)
            local1 = $01
        Case $C1
            local0 = (Str player[se_getparamint()]\Field74)
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
            local98 = se_getparamint()
            setplayertype(local7, local98)
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
            local0 = (Str (player[se_getparamint()]\Field57 = $01))
            local1 = $01
        Case $D0
            local99 = createplayer(findfreeplayerid())
            If (local99 = Null) Then
                local94 = $00
            Else
                local94 = local99\Field30
                local100 = se_getparamstring()
                player[local94]\Field15 = local100
                player[local94]\Field57 = $01
                player[local94]\Field22 = $01
                player[local94]\Field38 = ((((((readbool(player[local94]\Field38, $01) Shl $01) + $01) + (readbool(player[local94]\Field38, $02) Shl $02)) + (readbool(player[local94]\Field38, $03) Shl $03)) + $00) + $20)
                player[local94]\Field25 = $01
                player[local94]\Field33 = $05
                player[local94]\Field36 = $00
                addlog((local100 + " has joined to server"), $00, $01, $00, $C0, $C0, $C0)
                mp_createplayerobject(local99\Field30)
                public_inqueue($23, $00)
                public_addparam($00, (Str local94), $01)
                callback($00)
            EndIf
            local0 = (Str local94)
            local1 = $01
        Case $D1
            local7 = se_getparamint()
            local0 = (Str player[local7]\Field60)
            local1 = $01
        Case $D2
            local7 = se_getparamint()
            local0 = (Str readbool(player[local7]\Field38, $04))
            local1 = $01
        Case $D3
            player[se_and_lua_tointarg($00)]\Field38 = (((((((readbool(player[local7]\Field38, $01) Shl $01) + $01) + (readbool(player[local7]\Field38, $02) Shl $02)) + (readbool(player[local7]\Field38, $03) Shl $03)) + (se_and_lua_tointarg($01) Shl $04)) + (readbool(player[local7]\Field38, $05) Shl $05)) + (readbool(player[local56]\Field38, $06) Shl $06))
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
            local50 = se_getparamfloat()
            player[local7]\Field3 = local50
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
            kick(se_and_lua_tointarg($00), se_and_lua_tostringarg($01), "3")
        Case $E7
            rcon_banip(se_getparamstring())
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
            addlog(se_and_lua_tostringarg($00), $00, $00, $01, $C0, $C0, $C0)
        Case $EE
            local28 = se_getparamstring()
            local101 = se_getparamstring()
            local102 = se_getparamstring()
            local103 = se_getparamstring()
            local1 = $03
            local0 = getinistring(local28, local101, local102, local103)
        Case $EF
            local28 = se_getparamstring()
            local101 = se_getparamstring()
            local102 = se_getparamstring()
            local103 = se_getparamstring()
            putinivalue(local28, local101, local102, local103)
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
            se_and_lua_returnint((- (se_and_lua_tointarg($00) < 0)))
            Return $00
        Case $F8
            se_and_lua_returnint(((se_intarg($00, $00) Xor (- (se_intarg($00, $00) < 0))) - (- (se_intarg($00, $00) < 0))))
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
            local100 = se_getparamstring()
            changeplayernickname(local7, local100)
        Case $11C
            local7 = se_getparamint()
            local10 = se_getparamstring()
            local104 = se_getparamint()
            local105 = se_getparamint()
            local106 = se_getparamint()
            changeplayertag(local7, local10, local104, local105, local106)
        Case $11D
            local0 = (Str (player[se_getparamint()]\Field160 = "PATRON"))
            local1 = $01
        Case $11E
            local0 = incomingversion
            local1 = $03
        Case $11F
            local0 = (Str incomingpatron)
            local1 = $01
        Case $120
            gameinfo\Field5\Field9 = (Int se_getparamfloat())
        Case $121
            gameinfo\Field5\Field10 = (Int se_getparamfloat())
        Case $122
            local0 = (Str gameinfo\Field5\Field9)
            local1 = $02
        Case $123
            local0 = (Str gameinfo\Field5\Field10)
            local1 = $02
        Case $124
            server\Field63 = se_getparamint()
        Case $15E
            local0 = (Str player[local107]\Field142)
            local1 = $01
        Case $15D
            local7 = se_getparamint()
            player[local7]\Field142 = se_getparamint()
        Case $126
            server\Field87\Field7 = se_getparamint()
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
