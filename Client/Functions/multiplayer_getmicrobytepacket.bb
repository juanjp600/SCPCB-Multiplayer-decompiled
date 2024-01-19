Function multiplayer_getmicrobytepacket%(arg0%, arg1%, arg2.players)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    Local local8.items
    Local local9.doors
    Local local10.players
    Local local11%
    Local local12#
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
    Local local24.decals
    Local local25%
    Local local26.particles
    Local local27%
    Local local28.decals
    Local local29$
    Local local30.chatmessage
    Local local31%
    Local local32.rooms
    Local local33%
    Local local34%
    Local local35%
    Local local36.itemtemplates
    Select arg0
        Case $6A
            udp_readshort()
            udp_readshort()
        Case $7C
            udp_readline()
            udp_readshort()
        Case $2C
            otherindex = udp_readshort()
            If (arg1 <> networkserver\Field28) Then
                For local8 = Each items
                    If (local8\Field18 = otherindex) Then
                        removeitem(local8, $00)
                        Exit
                    EndIf
                Next
            EndIf
        Case $15
            otherindex = udp_readshort()
            For local8 = Each items
                If (((local8\Field18 = otherindex) And (local8\Field22 = $00)) <> 0) Then
                    local8\Field22 = arg1
                    hideentity(local8\Field1)
                    local8\Field15 = $01
                    Exit
                EndIf
            Next
        Case $18
            otherindex = udp_readshort()
            For local8 = Each items
                If (((local8\Field18 = otherindex) And (local8\Field22 = arg1)) <> 0) Then
                    playerdropitem(local8)
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
            If (arg1 <> networkserver\Field28) Then
                For local9 = Each doors
                    If (local9\Field18 = otherindex) Then
                        local9\Field4 = otherindex3
                        If (local9\Field5 <> otherindex2) Then
                            usedoor(local9, $00, $01, $00, "", $01)
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            For local10 = Each players
                If (((local10\Field0 <> arg1) And (local10\Field0 <> $01)) <> 0) Then
                    udp_writebyte($17)
                    udp_writebyte($01)
                    udp_writeshort(otherindex)
                    udp_writebyte(otherindex2)
                    udp_writebyte(otherindex3)
                    udp_sendmessage(local10\Field0)
                EndIf
            Next
        Case $03
            otherindexstr = udp_readline()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            If (arg2 <> Null) Then
                If (arg2\Field13 <> $00) Then
                    If (arg1 <> networkserver\Field28) Then
                        playplayersound(arg2, otherindexstr, local0, local1, $00)
                    EndIf
                EndIf
            EndIf
            For local10 = Each players
                If (((local10\Field0 <> arg1) And (local10\Field0 <> $01)) <> 0) Then
                    udp_writebyte($03)
                    udp_writebyte(arg1)
                    udp_writeline(otherindexstr)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_sendmessage(local10\Field0)
                EndIf
            Next
        Case $05
            local11 = udp_readbyte()
            local12 = udp_readfloat()
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
            local24 = createdecal(local11, local12, local13, local14, local17, local15, local16, 1.0, 1.0)
            If (local11 = $05) Then
                entitycolor(local24\Field0, 0.0, rnd(200.0, 255.0), 0.0)
            EndIf
            local24\Field1 = local18
            local24\Field2 = local19
            local24\Field3 = local20
            local24\Field4 = local21
            local24\Field5 = local22
            local24\Field9 = local23
            entityalpha(local24\Field0, local24\Field5)
            scalesprite(local24\Field0, local24\Field2, local24\Field2)
            For local10 = Each players
                If (((local10\Field0 <> arg1) And (local10\Field0 <> $01)) <> 0) Then
                    udp_writebyte($05)
                    udp_writebyte($01)
                    udp_writebyte(local11)
                    udp_writefloat(local12)
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
                    udp_sendmessage(local10\Field0)
                EndIf
            Next
        Case $35
            local25 = udp_readbyte()
            If (local25 = networkserver\Field28) Then
                If (arg2\Field51 = model_106) Then
                    movetopocketdimension()
                    myplayer\Field70 = (myplayer\Field70 - 55.0)
                    If (1.0 > myplayer\Field70) Then
                        kill(("was killed by " + arg2\Field24), $00)
                    EndIf
                Else
                    kill(("was killed by " + arg2\Field24), $00)
                EndIf
            Else
                udp_writebyte($35)
                udp_writebyte($01)
                udp_sendmessage(local25)
            EndIf
        Case $2E
            local25 = udp_readbyte()
            If (local25 = networkserver\Field28) Then
                If (player_isdead() = $00) Then
                    If (multiplayer_isascp(myplayer\Field51) = $00) Then
                        local26 = createparticle(entityx(collider, $00), (entityy(collider, $00) - 0.1), entityz(collider, $00), $05, 0.06, 0.2, $50)
                        local26\Field9 = 0.001
                        local26\Field16 = 0.003
                        local26\Field6 = 0.8
                        local26\Field15 = -0.02
                        local27 = createpivot($00)
                        positionentity(local27, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
                        turnentity(local27, 90.0, 0.0, 0.0, $00)
                        entitypick(local27, 0.3)
                        local28 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0, 1.0, 1.0)
                        local28\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
                        entityalpha(local28\Field0, 1.0)
                        scalesprite(local28\Field0, local28\Field2, local28\Field2)
                        freeentity(local27)
                        multiplayer_writedecal(local28, $01, $01)
                        If (networkserver\Field15 = $00) Then
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
                            myplayer\Field70 = (myplayer\Field70 - (rnd((getgundamage(arg2\Field37) - 3.0), (getgundamage(arg2\Field37) + 3.0)) - (Float (wearingvest Shl $03))))
                            If (multiplayer_isascp(arg2\Field51) <> 0) Then
                                myplayer\Field70 = (myplayer\Field70 - (Float rand($1E, $28)))
                            EndIf
                            If (1.0 > myplayer\Field70) Then
                                kill(("was killed by " + arg2\Field24), $00)
                            EndIf
                        EndIf
                    Else
                        myplayer\Field70 = ((myplayer\Field70 - getgundamage(arg2\Field37)) - (Float rand($01, $02)))
                        injuries = 0.0
                        If (0.0 > myplayer\Field70) Then
                            godmode = $00
                            kill(("was killed by " + arg2\Field24), $00)
                        EndIf
                    EndIf
                EndIf
            Else
                udp_writebyte($2E)
                udp_writebyte($01)
                udp_sendmessage(local25)
            EndIf
        Case $0B
            local29 = udp_readline()
            If (udp_readbyte() <> 0) Then
                If (arg2 <> Null) Then
                    local30 = multiplayer_createmessage((arg2\Field24 + local29), $FFFFFFFF)
                Else
                    local30 = multiplayer_createmessage(local29, $FFFFFFFF)
                EndIf
                For local10 = Each players
                    If (local10\Field0 <> networkserver\Field28) Then
                        udp_writebyte($0B)
                        udp_writebyte($00)
                        udp_writeline(local30\Field0)
                        udp_writebyte($01)
                        udp_sendmessage(local10\Field0)
                    EndIf
                Next
            EndIf
        Case $6D
            local31 = udp_readbyte()
            If (((local31 > $00) And (local31 < $41)) <> 0) Then
                If (player[local31] <> Null) Then
                    udp_writebyte($6D)
                    udp_writebyte(local31)
                    udp_writeline(player[local31]\Field24)
                    udp_writeline(player[local31]\Field88)
                    udp_writebyte(player[local31]\Field89)
                    udp_writebyte(player[local31]\Field90)
                    udp_writebyte(player[local31]\Field91)
                    udp_writeshort($64)
                    udp_writeint(player[local31]\Field95)
                    udp_writebyte(player[local31]\Field50)
                    udp_sendmessage(arg1)
                EndIf
            EndIf
        Case $0E
            otherindex = udp_readbyte()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local5 = udp_readfloat()
            For local32 = Each rooms
                If (local32\Field65 = arg2\Field47) Then
                    rotateentity(local32\Field25[otherindex], local4, local3, local5, $01)
                    local32\Field26[otherindex] = $00
                    Exit
                EndIf
            Next
        Case $4A
            arg2\Field51 = (Int max(min((Float udp_readbyte()), (Float (last_breach_type - $01))), 0.0))
        Case $79
            If (arg1 = networkserver\Field28) Then
                myplayer\Field83 = $01
            Else
                udp_writebyte($79)
                udp_writebyte($01)
                udp_sendmessage(arg1)
            EndIf
            For local8 = Each items
                If (local8\Field22 = arg1) Then
                    playerdropitem(local8)
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
            If (arg1 <> networkserver\Field28) Then
                createrocket(15.0, local0, local1, local2, local4, local3, arg1)
                player[arg1]\Field99 = $01
            EndIf
            For local10 = Each players
                If (((local10\Field0 <> arg1) And (local10\Field0 <> $01)) <> 0) Then
                    udp_writebyte($51)
                    udp_writebyte($01)
                    udp_writeshort($00)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_writefloat(local2)
                    udp_writefloat(local4)
                    udp_writefloat(local3)
                    udp_sendmessage(local10\Field0)
                EndIf
            Next
        Case $74
            udp_readshort()
            local0 = udp_readfloat()
            local1 = udp_readfloat()
            local2 = udp_readfloat()
            local4 = udp_readfloat()
            local3 = udp_readfloat()
            local33 = udp_readbyte()
            local34 = udp_readbyte()
            If (arg1 <> networkserver\Field28) Then
                creategrenade(local33, local0, local1, local2, local4, local3, arg1, local34)
            EndIf
            For local10 = Each players
                If (((local10\Field0 <> arg1) And (local10\Field0 <> $01)) <> 0) Then
                    udp_writebyte($74)
                    udp_writebyte(arg1)
                    udp_writeshort($00)
                    udp_writefloat(local0)
                    udp_writefloat(local1)
                    udp_writefloat(local2)
                    udp_writefloat(local4)
                    udp_writefloat(local3)
                    udp_writebyte(local33)
                    udp_writebyte(local34)
                    udp_sendmessage(local10\Field0)
                EndIf
            Next
        Case $16
            local35 = udp_readint()
            If (arg1 <> networkserver\Field28) Then
                For local36 = Each itemtemplates
                    If (local36\Field0 = local35) Then
                        local8 = createitem(local36\Field1, local36\Field2, entityx(arg2\Field13, $00), (entityy(getplayercamera(arg1), $00) + 0.1), entityz(arg2\Field13, $00), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local8\Field1, $03, $00)
                        local8\Field22 = $00
                        Exit
                    EndIf
                Next
            EndIf
    End Select
    Return $00
End Function
