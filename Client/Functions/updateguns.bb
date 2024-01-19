Function updateguns%()
    Local local0.guns
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.players
    Local local7#
    Local local9%
    Local local10$
    Local local11.players
    Local local12#
    Local local13#
    Local local14#
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    holdinggun = $00
    local3 = $00
    local4 = $00
    local5 = $00
    If (spectate\Field1 <> $FFFFFFFF) Then
        eqquipedgun = Null
        holdinggun = $00
        If (spectate\Field0 = $01) Then
            If (player[spectate\Field1] <> Null) Then
                If (player[spectate\Field1]\Field37 > $00) Then
                    eqquipedgun = getguntype(player[spectate\Field1]\Field37)
                    If (eqquipedgun <> Null) Then
                        If (((eqquipedgun\Field0 < $0B) Or (eqquipedgun\Field0 = $0C)) <> 0) Then
                            If (eqquipedgun\Field6 = $00) Then
                                animate2(eqquipedgun\Field10, animtime(eqquipedgun\Field10), (Int getidleanim(eqquipedgun)), (Int getidleanim(eqquipedgun)), 1.0, $00)
                                eqquipedgun\Field8 = getidleanim(eqquipedgun)
                                eqquipedgun\Field6 = $01
                            EndIf
                        EndIf
                        If (player[spectate\Field1]\Field99 <> 0) Then
                            local3 = $01
                        EndIf
                        If (player[spectate\Field1]\Field100 <> 0) Then
                            local4 = $01
                        EndIf
                        If (player[spectate\Field1]\Field101 <> 0) Then
                            local5 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    For local6 = Each players
        local6\Field99 = $00
        local6\Field100 = $00
        local6\Field101 = $00
    Next
    local0 = eqquipedgun
    If (local0 <> preveqquipedgun) Then
        If (preveqquipedgun <> Null) Then
            hideentity(preveqquipedgun\Field10)
            hideentity(preveqquipedgun\Field24)
            If (((preveqquipedgun\Field0 < $0B) Or (preveqquipedgun\Field0 = $0C)) <> 0) Then
                preveqquipedgun\Field6 = $00
            EndIf
            If (preveqquipedgun\Field0 = $06) Then
                myplayer\Field82 = $00
            EndIf
            preveqquipedgun\Field3 = 0.0
            preveqquipedgun\Field5 = 0.0
            preveqquipedgun\Field7 = $00
            preveqquipedgun\Field8 = 0.0
            setanimtime(preveqquipedgun\Field10, 0.0, $00)
        EndIf
        preveqquipedgun = local0
    EndIf
    If (local0 <> Null) Then
        local7 = (cos(((Float millisecs()) * 0.07)) * 0.3)
        local0\Field8 = animtime(local0\Field10)
        rotateentity(gunpivot, curveangle((entitypitch(camera, $00) + local7), entitypitch(gunpivot, $00), 4.0), curveangle((entityyaw(camera, $00) + local7), entityyaw(gunpivot, $00), 4.0), (entityroll(camera, $00) + (local7 * 0.5)), $00)
        rotateentity(gunpivot, (entitypitch(gunpivot, $00) + min(6.0, recoil)), (entityyaw(gunpivot, $00) + getrecoillr()), entityroll(gunpivot, $00), $00)
        showentity(local0\Field10)
        holdinggun = local0\Field0
        If (local4 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field1 = $00
                local0\Field8 = getreloadanim(local0, $00)
                animate2(local0\Field10, animtime(local0\Field10), (Int getreloadanim(local0, $00)), (Int getreloadanim(local0, $00)), 0.5, $00)
                local0\Field5 = 1.0
            EndIf
        ElseIf (local3 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field7 = $00
                animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                local0\Field8 = getshootanim(local0, $00)
                local0\Field3 = 1.0
            EndIf
        ElseIf (local5 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field7 = $00
                animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                local0\Field8 = getshootanim(local0, $00)
                local0\Field3 = 1.0
            EndIf
        EndIf
        If ((((0.0 = local0\Field5) And (0.0 = local0\Field3)) And (spectate\Field1 = $FFFFFFFF)) <> 0) Then
            If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (drawhandicon = $00)) And (otheropen = Null)) And (menuopen = $00)) And (selecteddoor = Null)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field27 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
                If (local0\Field6 = $01) Then
                    If (((local0\Field1 < local0\Field2) And (local0\Field18 > $00)) <> 0) Then
                        If (getidleanim(local0) = animtime(local0\Field10)) Then
                            If (lockmouse = $00) Then
                                If (keyhit(key_reload) <> 0) Then
                                    local0\Field1 = $00
                                    playgunsound(local0\Field9, 10.0, $01)
                                    local0\Field8 = getreloadanim(local0, $00)
                                    animate2(local0\Field10, animtime(local0\Field10), (Int getreloadanim(local0, $00)), (Int getreloadanim(local0, $00)), 0.5, $00)
                                    local0\Field5 = 1.0
                                    settempammotext()
                                EndIf
                            EndIf
                        ElseIf (keyhit(key_reload) <> 0) Then
                            settempammotext()
                            flushkeys()
                        EndIf
                    ElseIf (keyhit(key_reload) <> 0) Then
                        flushkeys()
                        settempammotext()
                    EndIf
                ElseIf (keyhit(key_reload) <> 0) Then
                    flushkeys()
                    settempammotext()
                EndIf
            EndIf
        ElseIf (((0.0 < local0\Field5) And (0.0 = local0\Field3)) <> 0) Then
            animate2(local0\Field10, animtime(local0\Field10), (Int getreloadanim(local0, $00)), (Int getreloadanim(local0, $01)), 0.5, $00)
            If ((((getreloadanim(local0, $01) - 1.0) > local0\Field8) And ((getreloadanim(local0, $01) - 1.0) <= animtime(local0\Field10))) <> 0) Then
                local0\Field1 = local0\Field2
                local0\Field18 = (local0\Field18 - $01)
                local0\Field5 = 0.0
                animate2(local0\Field10, animtime(local0\Field10), (Int getidleanim(local0)), (Int getidleanim(local0)), 1.0, $00)
                local0\Field8 = getidleanim(local0)
                If (spectate\Field1 = $FFFFFFFF) Then
                    settempammotext()
                EndIf
            EndIf
        EndIf
        If (0.0 = local0\Field5) Then
            If (local0\Field6 = $00) Then
                animate2(local0\Field10, animtime(local0\Field10), (Int getdeployanim(local0, $00)), (Int getdeployanim(local0, $01)), 0.5, $00)
                If (((getdeployframe(local0) > local0\Field8) And (getdeployframe(local0) <= animtime(local0\Field10))) <> 0) Then
                    playgunsound(local0\Field21, 10.0, $01)
                ElseIf ((((getdeployanim(local0, $01) - 0.5) > local0\Field8) And ((getdeployanim(local0, $01) - 0.5) <= animtime(local0\Field10))) <> 0) Then
                    animate2(local0\Field10, animtime(local0\Field10), (Int getidleanim(local0)), (Int getidleanim(local0)), 1.0, $00)
                    local0\Field8 = getidleanim(local0)
                    local0\Field6 = $01
                EndIf
            Else
                If (local0\Field7 = $01) Then
                    animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $01)), 0.5, $00)
                    If ((((getshootanim(local0, $01) - 1.0) > local0\Field8) And ((getshootanim(local0, $01) - 1.0) <= animtime(local0\Field10))) <> 0) Then
                        animate2(local0\Field10, animtime(local0\Field10), (Int getidleanim(local0)), (Int getidleanim(local0)), 1.0, $00)
                        local0\Field8 = getidleanim(local0)
                        local0\Field7 = $00
                    EndIf
                EndIf
                If (spectate\Field1 = $FFFFFFFF) Then
                    If (0.0 = local0\Field3) Then
                        If (((local0\Field23 = $01) Or (local0\Field1 < $01)) <> 0) Then
                            If ((mousehit1 And (lockmouse = $00)) <> 0) Then
                                If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (otheropen = Null)) And (drawhandicon = $00)) And (selecteddoor = Null)) And (menuopen = $00)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field27 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
                                    local0\Field7 = $00
                                    animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                                    local0\Field8 = getshootanim(local0, $00)
                                    local0\Field3 = 1.0
                                    If (local0\Field0 = $06) Then
                                        playgunsound(local0\Field19, 5.0, $01)
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf ((mousedown1 And (lockmouse = $00)) <> 0) Then
                            If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (otheropen = Null)) And (drawhandicon = $00)) And (selecteddoor = Null)) And (menuopen = $00)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field27 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
                                local0\Field7 = $00
                                animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                                local0\Field8 = getshootanim(local0, $00)
                                local0\Field3 = 1.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
                If (1.0 = local0\Field3) Then
                    Select local0\Field0
                        Case $06
                            local0\Field3 = 1.01
                        Case $04
                            If (local3 <> 0) Then
                                showentity(local0\Field24)
                                rotateentity(local0\Field24, 0.0, 0.0, rnd(360.0, 0.0), $00)
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            ElseIf (((local0\Field1 > $00) And (local5 = $00)) <> 0) Then
                                If (udp_getstream() <> 0) Then
                                    For local9 = $00 To $09 Step $01
                                        If (inventory(local9) <> Null) Then
                                            If (isagun(inventory(local9)\Field3\Field2) = local0\Field0) Then
                                                udp_bytestreamwritechar($51)
                                                udp_bytestreamwriteshort(inventory(local9)\Field18)
                                                udp_bytestreamwritefloat(entityx(camera, $00))
                                                udp_bytestreamwritefloat((entityy(camera, $00) - 0.1))
                                                udp_bytestreamwritefloat(entityz(camera, $00))
                                                udp_bytestreamwritefloat(entitypitch(camera, $00))
                                                udp_bytestreamwritefloat(entityyaw(camera, $00))
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                createrocket(15.0, entityx(camera, $00), (entityy(camera, $00) - 0.1), entityz(camera, $00), entitypitch(camera, $00), entityyaw(camera, $00), myplayer\Field0)
                                recoil = curvevalue(20.0, recoil, ((15.0 - local0\Field11) - rnd(1.0, 2.0)))
                                local0\Field3 = 1.01
                                local0\Field1 = (local0\Field1 - $01)
                            Else
                                playsound_strict(shootemptysfx)
                                multiplayer_writesound(shootemptysfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                local0\Field3 = 100.0
                            EndIf
                        Case $0D,$0E,$0F
                            If (spectate\Field1 = $FFFFFFFF) Then
                                creategrenade(eqquipedgun\Field0, entityx(camera, $00), (entityy(camera, $00) - 0.1), entityz(camera, $00), entitypitch(camera, $00), entityyaw(camera, $00), networkserver\Field28, eqquipedgun\Field35)
                                If (udp_getstream() <> 0) Then
                                    For local9 = $00 To $09 Step $01
                                        If (inventory(local9) <> Null) Then
                                            If (isagun(inventory(local9)\Field3\Field2) = local0\Field0) Then
                                                udp_bytestreamwritechar($74)
                                                udp_bytestreamwriteshort(inventory(local9)\Field18)
                                                udp_bytestreamwritefloat(entityx(camera, $00))
                                                udp_bytestreamwritefloat((entityy(camera, $00) - 0.1))
                                                udp_bytestreamwritefloat(entityz(camera, $00))
                                                udp_bytestreamwritefloat(entitypitch(camera, $00))
                                                udp_bytestreamwritefloat(entityyaw(camera, $00))
                                                udp_bytestreamwritechar(eqquipedgun\Field0)
                                                udp_bytestreamwritechar(eqquipedgun\Field35)
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                eqquipedgun\Field35 = $00
                                onplayerdropgrenade(eqquipedgun\Field0)
                                eqquipedgun = Null
                                local0\Field3 = 1.01
                            EndIf
                        Case $0B
                            If (usehandcuffs() <> 0) Then
                                eqquipedgun = Null
                                local0\Field3 = 1.01
                            Else
                                local0\Field3 = 0.0
                            EndIf
                        Case $0C
                            If (local3 = $00) Then
                                entitypickmode(collider, $00, $01)
                                entitypickmode(myhitbox, $00, $00)
                                local10 = (("SFX\Guns\Knife\knife_miss" + (Str rand($01, $03))) + ".ogg")
                                If (entitypick(camera, 0.5) <> 0) Then
                                    local10 = "SFX\Guns\Knife\knife_wall.ogg"
                                    For local9 = $00 To $09 Step $01
                                        If (inventory(local9) <> Null) Then
                                            If (isagun(inventory(local9)\Field3\Field2) = local0\Field0) Then
                                                For local11 = Each players
                                                    If ((((pickedentity() = local11\Field19) Or (pickedentity() = local11\Field12)) Or (pickedentity() = local11\Field13)) <> 0) Then
                                                        udp_bytestreamwritechar($80)
                                                        udp_bytestreamwriteshort(inventory(local9)\Field18)
                                                        udp_bytestreamwritechar(local11\Field0)
                                                        local10 = "SFX\Guns\Knife\knife_slash.ogg"
                                                        Exit
                                                    EndIf
                                                Next
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                playsound_strict(loadtempsound(local10))
                                multiplayer_writetempsound(local10, 0.0, 0.0, 0.0, 10.0, 1.0)
                                entitypickmode(collider, $01, $01)
                                entitypickmode(myhitbox, $02, $00)
                            EndIf
                            local0\Field3 = 1.01
                            local0\Field7 = $01
                        Default
                            If (local3 <> 0) Then
                                showentity(local0\Field24)
                                rotateentity(local0\Field24, 0.0, 0.0, rnd(360.0, 0.0), $00)
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            ElseIf (((local0\Field1 > $00) And (local5 = $00)) <> 0) Then
                                showentity(local0\Field24)
                                rotateentity(local0\Field24, 0.0, 0.0, rnd(360.0, 0.0), $00)
                                local12 = ((Float (eqquipedgun\Field29 Shl $02)) / (Float (((($05 * crouch) * local0\Field0) = $08) + $0A)))
                                If (0.0 = local12) Then
                                    local12 = 1.0
                                EndIf
                                local12 = ((currspeed * 50.0) + local12)
                                recoil = ((local12 * 8.0) + recoil)
                                If (local3 = $00) Then
                                    playgunsound(local0\Field19, 5.0, $00)
                                    If (udp_network\Field0 <> $00) Then
                                        For local9 = $00 To $09 Step $01
                                            If (inventory(local9) <> Null) Then
                                                If (isagun(inventory(local9)\Field3\Field2) = local0\Field0) Then
                                                    If (multiplayer_isfullsync() = $00) Then
                                                        udp_writebyte($6B)
                                                        udp_writebyte(networkserver\Field28)
                                                        udp_writeshort(inventory(local9)\Field18)
                                                        udp_writefloat(entityx(local0\Field24, $01))
                                                        udp_writefloat(entityy(local0\Field24, $01))
                                                        udp_writefloat(entityz(local0\Field24, $01))
                                                        udp_writefloat(entitypitch(camera, $01))
                                                        udp_writefloat(entityyaw(camera, $01))
                                                        udp_writebyte((Int (local12 * 10.0)))
                                                        udp_sendmessage($00)
                                                    Else
                                                        If (myplayer\Field103 <> Null) Then
                                                            removebytestream(myplayer\Field103)
                                                        EndIf
                                                        myplayer\Field103 = createbytestream($17)
                                                        bytestreamwriteshort(myplayer\Field103, inventory(local9)\Field18)
                                                        bytestreamwritefloat(myplayer\Field103, entityx(local0\Field24, $01))
                                                        bytestreamwritefloat(myplayer\Field103, entityy(local0\Field24, $01))
                                                        bytestreamwritefloat(myplayer\Field103, entityz(local0\Field24, $01))
                                                        bytestreamwritefloat(myplayer\Field103, entitypitch(camera, $01))
                                                        bytestreamwritefloat(myplayer\Field103, entityyaw(camera, $01))
                                                        bytestreamwritechar(myplayer\Field103, (Int (local12 * 10.0)))
                                                    EndIf
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                    local0\Field1 = (local0\Field1 - $01)
                                EndIf
                                For local9 = $01 To local0\Field33 Step $01
                                    local13 = rnd((local0\Field34 * (- local12)), (local0\Field34 * local12))
                                    local14 = rnd((local0\Field34 * (- local12)), (local0\Field34 * local12))
                                    createbullet(networkserver\Field28, 1.0, entityx(local0\Field24, $01), entityy(local0\Field24, $01), entityz(local0\Field24, $01), ((entitypitch(camera, $01) + local13) - 2.0), (entityyaw(camera, $01) + local14))
                                Next
                                recoil = curvevalue(20.0, recoil, ((15.0 - local0\Field11) - rnd(1.0, 2.0)))
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            Else
                                playsound_strict(shootemptysfx)
                                multiplayer_writesound(shootemptysfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                local0\Field3 = 100.0
                            EndIf
                    End Select
                EndIf
                If (1.01 <= local0\Field3) Then
                    local0\Field3 = (local0\Field3 + fpsfactornolimit)
                    local15 = local0\Field0
                    If (local15 = $06) Then
                        If (((455.0 < local0\Field3) And (1020.0 > local0\Field3)) <> 0) Then
                            If (spectate\Field1 = $FFFFFFFF) Then
                                myplayer\Field82 = $01
                                local0\Field1 = $00
                            EndIf
                        Else
                            myplayer\Field82 = $00
                        EndIf
                        animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $01)), 0.25, $00)
                    EndIf
                    If (local0\Field4 <= (local0\Field3 - 1.01)) Then
                        hideentity(local0\Field24)
                        If (local0\Field0 <> $0B) Then
                            local0\Field7 = $01
                        EndIf
                        local0\Field3 = 0.0
                        local16 = local0\Field0
                        If (local16 = $06) Then
                            local0\Field7 = $00
                            eqquipedgun = Null
                            holdinggun = $00
                            For local9 = $00 To $09 Step $01
                                If (inventory(local9) <> Null) Then
                                    If (isagun(inventory(local9)\Field3\Field2) = local0\Field0) Then
                                        removeitem(inventory(local9), $01)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If ((((0.0 = local0\Field5) And (local0\Field7 = $00)) And (0.0 = local0\Field3)) <> 0) Then
            If (local0\Field1 < $01) Then
                local17 = local0\Field0
                If (local17 = $04) Then
                EndIf
            EndIf
        EndIf
    EndIf
    If (spectate\Field1 = $FFFFFFFF) Then
        If (eqquipedgun <> Null) Then
            local18 = $00
            For local9 = $00 To $09 Step $01
                If (inventory(local9) <> Null) Then
                    If (((isagun(inventory(local9)\Field3\Field2) = eqquipedgun\Field0) And (inventory(local9)\Field22 = networkserver\Field28)) <> 0) Then
                        local18 = $01
                        Exit
                    EndIf
                EndIf
            Next
            If (local18 = $00) Then
                eqquipedgun = Null
                holdinggun = $00
            EndIf
        EndIf
    EndIf
    If (holdinggun = $00) Then
        recoil = 0.0
        currentfov = curvevalue(mainfov, currentfov, 5.0)
    EndIf
    blockguns = $00
    drawhandicon = $00
    Return $00
End Function
