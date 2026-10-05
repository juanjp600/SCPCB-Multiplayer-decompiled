Function multiplayer_getmicrobytepacket%(arg0%, arg1%, arg2.players)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local9.items
    Local local10.doors
    Local local11.players
    Local local12%
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25.decals
    Local local26%
    Local local27.particles
    Local local28%
    Local local29.decals
    Local local30$
    Local local31.chatmessage
    Local local32%
    Local local33.rooms
    Local local34%
    Local local35%
    Local local36%
    Local local37.itemtemplates
    local7 = $01
    Select arg0
        Case $6A
            udp_readshort()
            udp_readshort()
        Case $7C
            udp_readline()
            udp_readshort()
        Case $2C
            otherindex = udp_readshort()
            If (arg1 <> networkserver\Field20) Then
                For local9 = Each items
                    If (local9\Field19 = otherindex) Then
                        removeitem(local9, $00)
                        Exit
                    EndIf
                Next
            EndIf
        Case $15
            otherindex = udp_readshort()
            For local9 = Each items
                If (((local9\Field19 = otherindex) And (local9\Field22 = $00)) <> 0) Then
                    local9\Field22 = arg1
                    hideentity(local9\Field2)
                    local9\Field16 = $01
                    Exit
                EndIf
            Next
        Case $18
            otherindex = udp_readshort()
            For local9 = Each items
                If (((local9\Field19 = otherindex) And (local9\Field22 = arg1)) <> 0) Then
                    playerdropitem(local9)
                    local9\Field22 = $00
                    selecteditem = Null
                    Exit
                EndIf
            Next
        Case $77
            onplayerconsole(arg1, udp_readline())
        Case $17
            otherindex = udp_readshort()
            otherindex2 = udp_readbyte()
            otherindex3 = udp_readbyte()
            udp_readshort()
            udp_readline()
            If (arg1 <> networkserver\Field20) Then
                For local10 = Each doors
                    If (local10\Field18 = otherindex) Then
                        local10\Field4 = otherindex3
                        If (local10\Field5 <> otherindex2) Then
                            usedoor(local10, $00, $01, $00, "", $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            For local11 = Each players
                If (((local11\Field0 <> arg1) And (local11\Field0 <> $01)) <> 0) Then
                    udp_writebyte($17)
                    udp_writebyte($01)
                    udp_writeshort(otherindex)
                    udp_writebyte(otherindex2)
                    udp_writebyte(otherindex3)
                    udp_sendmessage(local11\Field0)
                EndIf
            Next
        Case $03
            otherindexstr = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            If (issafeserversound(otherindexstr) = $00) Then
                Return $00
            EndIf
            If (arg2 <> Null) Then
                If (arg2\Field13 <> $00) Then
                    If (arg1 <> networkserver\Field20) Then
                        playplayersound(arg2, otherindexstr, local0, local1, $00)
                    EndIf
                EndIf
            EndIf
            For local11 = Each players
                If (((local11\Field0 <> arg1) And (local11\Field0 <> $01)) <> 0) Then
                    udp_writebyte($03)
                    udp_writebyte(arg1)
                    udp_writeline(otherindexstr)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_sendmessage(local11\Field0)
                EndIf
            Next
        Case $05
            local12 = udp_readbyte()
            local13 = udp_readfloat()
            local14 = udp_readfloat()
            local15 = udp_readfloat()
            local16 = udp_readfloat()
            local17 = udp_readfloat()
            local18 = udp_readfloat()
            local19 = udp_readfloat()
            local20 = udp_readfloat()
            local21 = udp_readfloat()
            local22 = udp_readfloat()
            local23 = udp_readfloat()
            local24 = udp_readfloat()
            local25 = createdecal(local12, local13, local14, local15, local18, local16, local17, 1.0, 1.0)
            If (local12 = $05) Then
                entitycolor(local25\Field0, 0.0, rnd(200.0, 255.0), 0.0)
            EndIf
            local25\Field1 = local19
            local25\Field2 = local20
            local25\Field3 = local21
            local25\Field4 = local22
            local25\Field5 = local23
            local25\Field9 = local24
            entityalpha(local25\Field0, local25\Field5)
            scalesprite(local25\Field0, local25\Field2, local25\Field2)
            For local11 = Each players
                If (((local11\Field0 <> arg1) And (local11\Field0 <> $01)) <> 0) Then
                    udp_writebyte($05)
                    udp_writebyte($01)
                    udp_writebyte(local12)
                    udp_writefloat(local13)
                    udp_writefloat(local14)
                    udp_writefloat(local15)
                    udp_writefloat(local16)
                    udp_writefloat(local17)
                    udp_writefloat(local18)
                    udp_writefloat(local19)
                    udp_writefloat(local20)
                    udp_writefloat(local21)
                    udp_writefloat(local22)
                    udp_writefloat(local23)
                    udp_writefloat(local24)
                    udp_sendmessage(local11\Field0)
                EndIf
            Next
        Case $35
            local26 = udp_readbyte()
            If (local26 = networkserver\Field20) Then
                If (arg2\Field49 = model_106) Then
                    movetopocketdimension()
                    stopchannel(local11\Field51)
                    local11\Field51 = $00
                    myplayer\Field68 = (myplayer\Field68 - 55.0)
                    If (1.0 > myplayer\Field68) Then
                        kill(("was killed by " + arg2\Field24), $00)
                    EndIf
                Else
                    kill(("was killed by " + arg2\Field24), $00)
                    stopchannel(local11\Field51)
                    local11\Field51 = $00
                EndIf
            Else
                udp_writebyte($35)
                udp_writebyte($01)
                udp_sendmessage(local26)
            EndIf
        Case $2E
            local26 = udp_readbyte()
            If (local26 = networkserver\Field20) Then
                If (player_isdead() = $00) Then
                    If (multiplayer_isascp(myplayer\Field49) = $00) Then
                        local27 = createparticle(entityx(collider, $00), (entityy(collider, $00) - 0.1), entityz(collider, $00), $05, 0.06, 0.2, $50, 1.0, $01)
                        local27\Field6 = 0.001
                        local27\Field13 = 0.003
                        local27\Field3 = 0.8
                        local27\Field12 = -0.02
                        local28 = createpivot($00)
                        positionentity(local28, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                        turnentity(local28, 90.0, 0.0, 0.0, $00)
                        entitypick(local28, 0.3)
                        local29 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local29\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                        entityalpha(local29\Field0, 1.0)
                        scalesprite(local29\Field0, local29\Field2, local29\Field2)
                        freeentity(local28)
                        multiplayer_writedecal(local29, $01, $01)
                        If (networkserver\Field12 = $00) Then
                            injuries = (rnd(2.0, 3.0) + injuries)
                            If (10.0 <= injuries) Then
                                kill(("was killed by " + arg2\Field24), $00)
                            EndIf
                        Else
                            If (1.0 >= injuries) Then
                                injuries = 1.01
                            Else
                                injuries = (injuries + 0.01)
                            EndIf
                            myplayer\Field68 = (myplayer\Field68 - (rnd((getgundamage(arg2\Field35) - 3.0), (getgundamage(arg2\Field35) + 3.0)) - (Float (wearingvest Shl $03))))
                            If (multiplayer_isascp(arg2\Field49) <> 0) Then
                                myplayer\Field68 = (myplayer\Field68 - (Float rand($1E, $28)))
                            EndIf
                            If (1.0 > myplayer\Field68) Then
                                kill(("was killed by " + arg2\Field24), $00)
                            EndIf
                        EndIf
                    Else
                        myplayer\Field68 = ((myplayer\Field68 - getgundamage(arg2\Field35)) - (Float rand($01, $02)))
                        injuries = 0.0
                        If (0.0 > myplayer\Field68) Then
                            godmode = $00
                            kill(("was killed by " + arg2\Field24), $00)
                        EndIf
                    EndIf
                EndIf
            Else
                udp_writebyte($2E)
                udp_writebyte($01)
                udp_sendmessage(local26)
            EndIf
        Case $0B
            local30 = udp_readline()
            If (udp_readbyte() <> 0) Then
                If (arg2 <> Null) Then
                    local31 = multiplayer_createmessage((arg2\Field24 + local30), $FFFFFFFF)
                Else
                    local31 = multiplayer_createmessage(local30, $FFFFFFFF)
                EndIf
                For local11 = Each players
                    If (local11\Field0 <> networkserver\Field20) Then
                        udp_writebyte($0B)
                        udp_writebyte($00)
                        udp_writeline(local31\Field0)
                        udp_writebyte($01)
                        udp_sendmessage(local11\Field0)
                    EndIf
                Next
            EndIf
        Case $6D
            local32 = udp_readbyte()
            If (((local32 > $00) And (local32 < $41)) <> 0) Then
                If (player[local32] <> Null) Then
                    udp_writebyte($6D)
                    udp_writebyte(local32)
                    udp_writeline(player[local32]\Field24)
                    udp_writeline(player[local32]\Field86)
                    udp_writebyte(player[local32]\Field87)
                    udp_writebyte(player[local32]\Field88)
                    udp_writebyte(player[local32]\Field89)
                    udp_writeshort($64)
                    udp_writeline(player[local32]\Field93)
                    udp_writebyte(player[local32]\Field48)
                    udp_sendmessage(arg1)
                EndIf
            EndIf
        Case $0E
            otherindex = udp_readbyte()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local5 = udp_readfloat()
            For local33 = Each rooms
                If (local33\Field65 = arg2\Field45) Then
                    rotateentity(local33\Field25[otherindex], local4, local3, local5, $01)
                    local33\Field26[otherindex] = $00
                    Exit
                EndIf
            Next
        Case $4A
            arg2\Field49 = (Int max(min((Float udp_readbyte()), (Float (last_breach_type - $01))), 0.0))
        Case $79
            If (arg1 = networkserver\Field20) Then
                myplayer\Field81 = $01
            Else
                udp_writebyte($79)
                udp_writebyte($01)
                udp_sendmessage(arg1)
            EndIf
            For local9 = Each items
                If (local9\Field22 = arg1) Then
                    playerdropitem(local9)
                EndIf
            Next
        Case $80
            udp_readshort()
            udp_writebyte($80)
            udp_writebyte($01)
            udp_sendmessage(udp_readbyte())
        Case $51
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            If (arg1 <> networkserver\Field20) Then
                createrocket(15.0, local0, local1, local2, local4, local3, arg1)
                player[arg1]\Field99 = $01
            EndIf
            For local11 = Each players
                If (((local11\Field0 <> arg1) And (local11\Field0 <> $01)) <> 0) Then
                    udp_writebyte($51)
                    udp_writebyte($01)
                    udp_writeshort($00)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_writefloat(local2)
                    udp_writefloat(local4)
                    udp_writefloat(local3)
                    udp_sendmessage(local11\Field0)
                EndIf
            Next
        Case $74
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local34 = udp_readbyte()
            local35 = udp_readbyte()
            If (arg1 <> networkserver\Field20) Then
                creategrenade(local34, local0, local1, local2, local4, local3, arg1, local35)
            EndIf
            For local11 = Each players
                If (((local11\Field0 <> arg1) And (local11\Field0 <> $01)) <> 0) Then
                    udp_writebyte($74)
                    udp_writebyte(arg1)
                    udp_writeshort($00)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_writefloat(local2)
                    udp_writefloat(local4)
                    udp_writefloat(local3)
                    udp_writebyte(local34)
                    udp_writebyte(local35)
                    udp_sendmessage(local11\Field0)
                EndIf
            Next
        Case $16
            local36 = udp_readint()
            If (arg1 <> networkserver\Field20) Then
                For local37 = Each itemtemplates
                    If (local37\Field0 = local36) Then
                        local9 = createitem(local37\Field1, local37\Field2, entityx(arg2\Field13, $00), (entityy(getplayercamera(arg1), $00) + 0.1), entityz(arg2\Field13, $00), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local9\Field2, $03, $00)
                        local9\Field22 = $00
                        Exit
                    EndIf
                Next
            EndIf
        Default
            local7 = $00
    End Select
    Return local7
    Return $00
End Function
