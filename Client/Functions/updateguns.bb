Function updateguns%()
    Local local0.guns
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.players
    Local local7%
    Local local8$
    Local local9.players
    Local local10#
    Local local11%
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18%
    Local local19%
    Local local20%
    holdinggun = $00
    hideentity(shootlight)
    local2 = $00
    local3 = $00
    local4 = $00
    If (spectate\Field1 <> $FFFFFFFF) Then
        eqquipedgun = Null
        holdinggun = $00
        If (spectate\Field0 = $01) Then
            If (player[spectate\Field1] <> Null) Then
                If (player[spectate\Field1]\Field35 > $00) Then
                    eqquipedgun = getguntype(player[spectate\Field1]\Field35)
                    If (eqquipedgun <> Null) Then
                        If (((eqquipedgun\Field0 < $0B) Or (eqquipedgun\Field0 = $0C)) <> 0) Then
                            If (eqquipedgun\Field6 = $00) Then
                                animate2(eqquipedgun\Field10, animtime(eqquipedgun\Field10), (Int getidleanim(eqquipedgun)), (Int getidleanim(eqquipedgun)), 1.0, $00)
                                eqquipedgun\Field8 = getidleanim(eqquipedgun)
                                eqquipedgun\Field6 = $01
                            EndIf
                        EndIf
                        If (player[spectate\Field1]\Field99 <> 0) Then
                            local2 = $01
                        EndIf
                        If (player[spectate\Field1]\Field100 <> 0) Then
                            local3 = $01
                        EndIf
                        If (player[spectate\Field1]\Field101 <> 0) Then
                            local4 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    For local5 = Each players
        local5\Field99 = $00
        local5\Field100 = $00
        local5\Field101 = $00
    Next
    local0 = eqquipedgun
    If (local0 <> preveqquipedgun) Then
        If (preveqquipedgun <> Null) Then
            hideentity(preveqquipedgun\Field10)
            hideentity(preveqquipedgun\Field25)
            If (((preveqquipedgun\Field0 < $0B) Or (preveqquipedgun\Field0 = $0C)) <> 0) Then
                preveqquipedgun\Field6 = $00
            EndIf
            If (preveqquipedgun\Field0 = $06) Then
                myplayer\Field80 = $00
            EndIf
            preveqquipedgun\Field3 = 0.0
            preveqquipedgun\Field5 = 0.0
            preveqquipedgun\Field7 = $00
            preveqquipedgun\Field8 = 0.0
            setanimtime(preveqquipedgun\Field10, 0.0, $00)
            positionentity(preveqquipedgun\Field38, 0.0, 0.0, 0.0, $00)
            rotateentity(preveqquipedgun\Field38, 0.0, 0.0, 0.0, $00)
        EndIf
        preveqquipedgun = local0
    EndIf
    If (local0 <> Null) Then
        local0\Field8 = animtime(local0\Field10)
        showentity(local0\Field10)
        holdinggun = local0\Field0
        If (local3 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field1 = $00
                local0\Field8 = getreloadanim(local0, $00)
                animate2(local0\Field10, animtime(local0\Field10), (Int getreloadanim(local0, $00)), (Int getreloadanim(local0, $00)), 0.5, $00)
                local0\Field5 = 1.0
            EndIf
        ElseIf (local2 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field7 = $00
                animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                local0\Field8 = getshootanim(local0, $00)
                local0\Field3 = 1.0
            EndIf
        ElseIf (local4 <> 0) Then
            If (0.0 = local0\Field5) Then
                local0\Field3 = 1.0
            EndIf
        EndIf
        If ((((0.0 = local0\Field5) And (0.0 = local0\Field3)) And (spectate\Field1 = $FFFFFFFF)) <> 0) Then
            If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (drawhandicon = $00)) And (otheropen = Null)) And (menuopen = $00)) And (selecteddoor = Null)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field19 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
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
                                EndIf
                            EndIf
                        ElseIf (keyhit(key_reload) <> 0) Then
                            flushkeys()
                        EndIf
                    EndIf
                ElseIf (keyhit(key_reload) <> 0) Then
                    flushkeys()
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
            EndIf
        EndIf
        If (0.0 = local0\Field5) Then
            If (local0\Field6 = $00) Then
                animate2(local0\Field10, animtime(local0\Field10), (Int getdeployanim(local0, $00)), (Int getdeployanim(local0, $01)), 0.5, $00)
                If (((getdeployframe(local0) > local0\Field8) And (getdeployframe(local0) <= animtime(local0\Field10))) <> 0) Then
                    playgunsound(local0\Field22, 10.0, $01)
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
                        If (((local0\Field24 = $01) Or (local0\Field1 < $01)) <> 0) Then
                            If ((mousehit1 And (lockmouse = $00)) <> 0) Then
                                If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (otheropen = Null)) And (drawhandicon = $00)) And (selecteddoor = Null)) And (menuopen = $00)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field19 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
                                    local0\Field7 = $00
                                    animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $00)), 0.5, $00)
                                    local0\Field8 = getshootanim(local0, $00)
                                    local0\Field3 = 1.0
                                    If (local0\Field0 = $06) Then
                                        playgunsound(local0\Field20, 5.0, $01)
                                    EndIf
                                EndIf
                            EndIf
                        ElseIf ((mousedown1 And (lockmouse = $00)) <> 0) Then
                            If ((((((((((((((closestbutton = $00) And (closestitem = Null)) And (grabbedentity = $00)) And (closestdoor = Null)) Or (mouseinteract = $00)) And (otheropen = Null)) And (drawhandicon = $00)) And (selecteddoor = Null)) And (menuopen = $00)) And (invopen = $00)) And (tab_menu_state < $02)) And (((networkserver\Field19 = $01) Or consoleopen) = $00)) And (blockguns = $00)) <> 0) Then
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
                            If (local2 <> 0) Then
                                showentity(local0\Field25)
                                rotatesprite(local0\Field25, rnd(360.0, 0.0))
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            ElseIf (((local0\Field1 > $00) And (local4 = $00)) <> 0) Then
                                showentity(local0\Field25)
                                If (udp_getstream() <> 0) Then
                                    For local7 = $00 To $09 Step $01
                                        If (inventory(local7) <> Null) Then
                                            If (isagun(inventory(local7)\Field1\Field2) = local0\Field0) Then
                                                udp_bytestreamwritechar($51)
                                                If (iscoopmode() <> 0) Then
                                                    udp_writebyte(networkserver\Field20)
                                                EndIf
                                                udp_bytestreamwriteshort(inventory(local7)\Field19)
                                                udp_bytestreamwritefloat(entityx(camera, $00))
                                                udp_bytestreamwritefloat((entityy(camera, $00) - 0.1))
                                                udp_bytestreamwritefloat(entityz(camera, $00))
                                                udp_bytestreamwritefloat(entitypitch(camera, $00))
                                                udp_bytestreamwritefloat(entityyaw(camera, $00))
                                                If (iscoopmode() <> 0) Then
                                                    udp_sendmessage($00)
                                                EndIf
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
                                local0\Field7 = $00
                            EndIf
                        Case $0D,$0E,$0F
                            If (spectate\Field1 = $FFFFFFFF) Then
                                creategrenade(eqquipedgun\Field0, entityx(camera, $00), (entityy(camera, $00) - 0.1), entityz(camera, $00), entitypitch(camera, $00), entityyaw(camera, $00), networkserver\Field20, eqquipedgun\Field37)
                                If (udp_getstream() <> 0) Then
                                    For local7 = $00 To $09 Step $01
                                        If (inventory(local7) <> Null) Then
                                            If (isagun(inventory(local7)\Field1\Field2) = local0\Field0) Then
                                                udp_bytestreamwritechar($74)
                                                If (iscoopmode() <> 0) Then
                                                    udp_writebyte(networkserver\Field20)
                                                EndIf
                                                udp_bytestreamwriteshort(inventory(local7)\Field19)
                                                udp_bytestreamwritefloat(entityx(camera, $00))
                                                udp_bytestreamwritefloat((entityy(camera, $00) - 0.1))
                                                udp_bytestreamwritefloat(entityz(camera, $00))
                                                udp_bytestreamwritefloat(entitypitch(camera, $00))
                                                udp_bytestreamwritefloat(entityyaw(camera, $00))
                                                udp_bytestreamwritechar(eqquipedgun\Field0)
                                                udp_bytestreamwritechar(eqquipedgun\Field37)
                                                If (iscoopmode() <> 0) Then
                                                    udp_sendmessage($00)
                                                EndIf
                                                Exit
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                eqquipedgun\Field37 = $00
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
                            If (local2 = $00) Then
                                entitypickmode(collider, $00, $01)
                                entitypickmode(myhitbox, $00, $00)
                                local8 = (("SFX\Guns\Knife\knife_miss" + (Str rand($01, $03))) + ".ogg")
                                If (entitypick(camera, 1.5) <> 0) Then
                                    local8 = "SFX\Guns\Knife\knife_wall.ogg"
                                    For local7 = $00 To $09 Step $01
                                        If (inventory(local7) <> Null) Then
                                            If (isagun(inventory(local7)\Field1\Field2) = local0\Field0) Then
                                                For local9 = Each players
                                                    If ((((pickedentity() = local9\Field19) Or (pickedentity() = local9\Field12)) Or (pickedentity() = local9\Field13)) <> 0) Then
                                                        udp_bytestreamwritechar($80)
                                                        If (iscoopmode() <> 0) Then
                                                            udp_writebyte(networkserver\Field20)
                                                        EndIf
                                                        udp_bytestreamwriteshort(inventory(local7)\Field19)
                                                        udp_bytestreamwritechar(local9\Field0)
                                                        If (iscoopmode() <> 0) Then
                                                            udp_sendmessage($00)
                                                        EndIf
                                                        local8 = "SFX\Guns\Knife\knife_slash.ogg"
                                                        Exit
                                                    EndIf
                                                Next
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                                playsound_strict(loadtempsound(local8))
                                multiplayer_writetempsound(local8, 0.0, 0.0, 0.0, 10.0, 1.0)
                                entitypickmode(collider, $01, $01)
                                entitypickmode(myhitbox, $02, $00)
                            EndIf
                            local0\Field3 = 1.01
                            local0\Field7 = $01
                        Default
                            If (local2 <> 0) Then
                                showentity(local0\Field25)
                                showentity(shootlight)
                                rotateentity(local0\Field25, 0.0, 0.0, rnd(360.0, 0.0), $00)
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            ElseIf (((local0\Field1 > $00) And (local4 = $00)) <> 0) Then
                                showentity(local0\Field25)
                                showentity(shootlight)
                                rotatesprite(local0\Field25, (Float rand($168, $01)))
                                local10 = ((1.1 - (Float eqquipedgun\Field31)) * 4.0)
                                local11 = (($05 * crouch) + $02)
                                local12 = (local10 / (Float local11))
                                local12 = max(0.0, ((currspeed * 100.0) + local12))
                                local13 = entityx(camera, $01)
                                local14 = entityy(camera, $01)
                                local15 = entityz(camera, $01)
                                If (local2 = $00) Then
                                    playgunsound(local0\Field20, 5.0, $00)
                                    If (udp_network\Field0 <> $00) Then
                                        For local7 = $00 To $09 Step $01
                                            If (inventory(local7) <> Null) Then
                                                If (isagun(inventory(local7)\Field1\Field2) = local0\Field0) Then
                                                    If (myplayer\Field103 <> Null) Then
                                                        removebytestream(myplayer\Field103)
                                                    EndIf
                                                    myplayer\Field103 = createbytestream($17)
                                                    udp_writebyte($6B)
                                                    udp_writebyte(networkserver\Field20)
                                                    udp_writeshort(inventory(local7)\Field19)
                                                    udp_writefloat(local13)
                                                    udp_writefloat(local14)
                                                    udp_writefloat(local15)
                                                    udp_writefloat(entitypitch(camera, $01))
                                                    udp_writefloat(entityyaw(camera, $01))
                                                    udp_writebyte((Int local12))
                                                    udp_sendmessage($00)
                                                    Exit
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                    local0\Field1 = (local0\Field1 - $01)
                                EndIf
                                For local7 = $01 To local0\Field35 Step $01
                                    local16 = (rnd((- local12), local12) * local0\Field36)
                                    local17 = (rnd((- local12), local12) * local0\Field36)
                                    createbullet(networkserver\Field20, 1.5, local13, local14, local15, (entitypitch(camera, $01) + local16), (entityyaw(camera, $01) + local17), $01)
                                Next
                                recoil = curvevalue(20.0, recoil, (15.0 - (local0\Field11 * local12)))
                                camerashake = f_clamp(recoil, 0.0, rnd(0.8, 1.2))
                                local0\Field3 = 1.01
                                local0\Field7 = $01
                            Else
                                playsound_strict(shootemptysfx)
                                multiplayer_writesound(shootemptysfx, 0.0, 0.0, 0.0, 10.0, 1.0)
                                local0\Field3 = 0.0
                                local0\Field7 = $00
                                animate2(local0\Field10, animtime(local0\Field10), (Int getidleanim(local0)), (Int getidleanim(local0)), 1.0, $00)
                                local0\Field8 = getidleanim(local0)
                            EndIf
                    End Select
                EndIf
                If (1.01 <= local0\Field3) Then
                    local0\Field3 = (local0\Field3 + fpsfactor)
                    local18 = local0\Field0
                    If (local18 = $06) Then
                        If (((455.0 < local0\Field3) And (1020.0 > local0\Field3)) <> 0) Then
                            If (spectate\Field1 = $FFFFFFFF) Then
                                myplayer\Field80 = $01
                                local0\Field1 = $00
                            EndIf
                        Else
                            myplayer\Field80 = $00
                        EndIf
                        animate2(local0\Field10, animtime(local0\Field10), (Int getshootanim(local0, $00)), (Int getshootanim(local0, $01)), 0.25, $00)
                    EndIf
                    If (local0\Field4 <= (local0\Field3 - 1.01)) Then
                        hideentity(local0\Field25)
                        If (local0\Field0 <> $0B) Then
                            local0\Field7 = $01
                        EndIf
                        local0\Field3 = 0.0
                        local19 = local0\Field0
                        If (local19 = $06) Then
                            local0\Field7 = $00
                            eqquipedgun = Null
                            holdinggun = $00
                            For local7 = $00 To $09 Step $01
                                If (inventory(local7) <> Null) Then
                                    If (isagun(inventory(local7)\Field1\Field2) = local0\Field0) Then
                                        removeitem(inventory(local7), $01)
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (spectate\Field1 = $FFFFFFFF) Then
        If (eqquipedgun <> Null) Then
            local20 = $00
            For local7 = $00 To $09 Step $01
                If (inventory(local7) <> Null) Then
                    If (((isagun(inventory(local7)\Field1\Field2) = eqquipedgun\Field0) And (inventory(local7)\Field22 = networkserver\Field20)) <> 0) Then
                        local20 = $01
                        Exit
                    EndIf
                EndIf
            Next
            If (local20 = $00) Then
                eqquipedgun = Null
                holdinggun = $00
            EndIf
        EndIf
    EndIf
    If (holdinggun = $00) Then
        recoil = 0.0
        currentfov = curvevalue(mainfov, currentfov, 3.0)
    EndIf
    blockguns = $00
    drawhandicon = $00
    Return $00
End Function
