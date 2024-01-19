Function savegame%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.npcs
    Local local5.rooms
    Local local6.doors
    Local local7%
    Local local8%
    Local local9%
    Local local10.decals
    Local local11.events
    Local local12.items
    Local local13%
    Local local14.itemtemplates
    If (playable = $00) Then
        Return $00
    EndIf
    If (((dropspeed > (0.02 * fpsfactor)) Or (dropspeed < (-0.02 * fpsfactor))) <> 0) Then
        Return $00
    EndIf
    If (0.0 > killtimer) Then
        Return $00
    EndIf
    gamesaved = $01
    createdir(arg0)
    local7 = writefile((arg0 + "save.txt"))
    writestring(local7, currenttime())
    writestring(local7, currentdate())
    writeint(local7, playtime)
    writefloat(local7, entityx(collider, $00))
    writefloat(local7, entityy(collider, $00))
    writefloat(local7, entityz(collider, $00))
    writefloat(local7, entityx(head, $00))
    writefloat(local7, entityy(head, $00))
    writefloat(local7, entityz(head, $00))
    writestring(local7, (Str accesscode))
    writefloat(local7, entitypitch(collider, $00))
    writefloat(local7, entityyaw(collider, $00))
    writefloat(local7, (Float deletecharfromstring(multiplayer_version, ".", $03)))
    writestring(local7, randomseed)
    For local2 = $00 To $03 Step $01
        If (selecteddifficulty = difficulties(local2)) Then
            writebyte(local7, local2)
            Exit
        EndIf
    Next
    writefloat(local7, blinktimer)
    writefloat(local7, blinkeffect)
    writefloat(local7, blinkeffecttimer)
    writeint(local7, (Int deathtimer))
    writeint(local7, (Int blurtimer))
    writefloat(local7, healtimer)
    writebyte(local7, crouch)
    writefloat(local7, stamina)
    writefloat(local7, staminaeffect)
    writefloat(local7, staminaeffecttimer)
    writefloat(local7, eyestuck)
    writefloat(local7, eyeirritation)
    writefloat(local7, injuries)
    writefloat(local7, bloodloss)
    writefloat(local7, previnjuries)
    writefloat(local7, prevbloodloss)
    writestring(local7, deathmsg)
    For local2 = $00 To $05 Step $01
        writefloat(local7, scp1025state[local2])
    Next
    writefloat(local7, vomittimer)
    writebyte(local7, vomit)
    writefloat(local7, camerashaketimer)
    writefloat(local7, infect)
    writefloat(local7, monitortimer)
    writefloat(local7, sanity)
    writebyte(local7, wearinggasmask)
    writebyte(local7, wearingvest)
    writebyte(local7, wearinghazmat)
    writebyte(local7, wearingnightvision)
    writebyte(local7, wearing1499)
    writefloat(local7, ntf_1499prevx)
    writefloat(local7, ntf_1499prevy)
    writefloat(local7, ntf_1499prevz)
    writefloat(local7, ntf_1499x)
    writefloat(local7, ntf_1499y)
    writefloat(local7, ntf_1499z)
    If (ntf_1499prevroom <> Null) Then
        writefloat(local7, ntf_1499prevroom\Field3)
        writefloat(local7, ntf_1499prevroom\Field5)
    Else
        writefloat(local7, 0.0)
        writefloat(local7, 0.0)
    EndIf
    writebyte(local7, superman)
    writefloat(local7, supermantimer)
    writebyte(local7, lightson)
    writestring(local7, randomseed)
    writefloat(local7, secondarylighton)
    writefloat(local7, prevsecondarylighton)
    writebyte(local7, remotedooron)
    writebyte(local7, soundtransmission)
    writebyte(local7, contained106)
    For local2 = $00 To $24 Step $01
        writebyte(local7, achievements(local2))
    Next
    writeint(local7, refineditems)
    writeint(local7, mapwidth)
    writeint(local7, mapheight)
    For local8 = $00 To $00 Step $01
        For local0 = $00 To mapwidth Step $01
            For local1 = $00 To mapheight Step $01
                writeint(local7, maptemp(local0, local1))
                writebyte(local7, mapfound(local0, local1))
            Next
        Next
    Next
    writeint(local7, $71)
    local3 = $00
    For local4 = Each npcs
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local4 = Each npcs
        debuglog((((("Saving NPC " + local4\Field43) + " (ID ") + (Str local4\Field6)) + ")"))
        writebyte(local7, local4\Field5)
        writefloat(local7, entityx(local4\Field4, $01))
        writefloat(local7, entityy(local4\Field4, $01))
        writefloat(local7, entityz(local4\Field4, $01))
        writefloat(local7, entitypitch(local4\Field4, $00))
        writefloat(local7, entityyaw(local4\Field4, $00))
        writefloat(local7, entityroll(local4\Field4, $00))
        writefloat(local7, local4\Field9)
        writefloat(local7, local4\Field10)
        writefloat(local7, local4\Field11)
        writeint(local7, local4\Field12)
        writebyte(local7, (Int local4\Field24))
        writefloat(local7, local4\Field27)
        writeint(local7, local4\Field26)
        writeint(local7, (Int local4\Field22))
        writefloat(local7, local4\Field15)
        writefloat(local7, local4\Field25)
        writeint(local7, local4\Field6)
        If (local4\Field31 <> Null) Then
            writeint(local7, local4\Field31\Field6)
        Else
            writeint(local7, $00)
        EndIf
        writefloat(local7, local4\Field33)
        writefloat(local7, local4\Field34)
        writefloat(local7, local4\Field35)
        writestring(local7, local4\Field23)
        writefloat(local7, animtime(local4\Field0))
        writeint(local7, local4\Field48)
        writefloat(local7, local4\Field60)
        writefloat(local7, local4\Field61)
        writeint(local7, local4\Field59)
        writestring(local7, local4\Field62)
        writefloat(local7, local4\Field63)
        writefloat(local7, local4\Field64)
        writefloat(local7, local4\Field65)
        writeint(local7, local4\Field67)
    Next
    writefloat(local7, mtftimer)
    For local2 = $00 To $06 Step $01
        writestring(local7, "a")
        writeint(local7, $00)
    Next
    writeint(local7, room2gw_brokendoor)
    writefloat(local7, room2gw_x)
    writefloat(local7, room2gw_z)
    writebyte(local7, i_zone\Field0[$00])
    writebyte(local7, i_zone\Field0[$01])
    writebyte(local7, i_zone\Field1)
    writebyte(local7, i_zone\Field2)
    writeint(local7, $278)
    local3 = $00
    For local5 = Each rooms
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local5 = Each rooms
        writeint(local7, local5\Field7\Field1)
        writeint(local7, local5\Field6)
        writefloat(local7, local5\Field3)
        writefloat(local7, local5\Field4)
        writefloat(local7, local5\Field5)
        writebyte(local7, local5\Field1)
        writeint(local7, local5\Field0)
        If (playerroom = local5) Then
            writebyte(local7, $01)
        Else
            writebyte(local7, $00)
        EndIf
        For local9 = $00 To $1D Step $01
            writebyte(local7, local5\Field26[local9])
        Next
        For local2 = $00 To $0B Step $01
            If (local5\Field32[local2] = Null) Then
                writeint(local7, $00)
            Else
                writeint(local7, local5\Field32[local2]\Field6)
            EndIf
        Next
        For local2 = $00 To $0A Step $01
            If (local5\Field28[local2] <> $00) Then
                If (0.0 < entitypitch(local5\Field28[local2], $01)) Then
                    writebyte(local7, $01)
                Else
                    writebyte(local7, $00)
                EndIf
            EndIf
        Next
        writebyte(local7, $02)
        If (local5\Field33 = Null) Then
            writebyte(local7, $00)
        Else
            writebyte(local7, $01)
            For local1 = $00 To $12 Step $01
                For local0 = $00 To $12 Step $01
                    writebyte(local7, local5\Field33\Field0[((local1 * $13) + local0)])
                    writebyte(local7, local5\Field33\Field1[((local1 * $13) + local0)])
                Next
            Next
        EndIf
        If (local5\Field11 = Null) Then
            writebyte(local7, $00)
        Else
            If (i_zone\Field1 = $00) Then
                writebyte(local7, $01)
            Else
                writebyte(local7, $02)
            EndIf
            For local1 = $00 To $09 Step $01
                For local0 = $00 To $09 Step $01
                    writebyte(local7, local5\Field11\Field2[((local1 * $0A) + local0)])
                Next
            Next
            writefloat(local7, entityx(local5\Field11\Field4, $01))
            writefloat(local7, entityy(local5\Field11\Field4, $01))
            writefloat(local7, entityz(local5\Field11\Field4, $01))
        EndIf
    Next
    writeint(local7, $3BA)
    local3 = $00
    For local6 = Each doors
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local6 = Each doors
        writefloat(local7, entityx(local6\Field2, $01))
        writefloat(local7, entityy(local6\Field2, $01))
        writefloat(local7, entityz(local6\Field2, $01))
        writebyte(local7, local6\Field5)
        writefloat(local7, local6\Field7)
        writebyte(local7, local6\Field4)
        writebyte(local7, local6\Field21)
        writefloat(local7, entityx(local6\Field0, $01))
        writefloat(local7, entityz(local6\Field0, $01))
        If (local6\Field1 <> $00) Then
            writefloat(local7, entityx(local6\Field1, $01))
            writefloat(local7, entityz(local6\Field1, $01))
        Else
            writefloat(local7, 0.0)
            writefloat(local7, 0.0)
        EndIf
        writefloat(local7, (Float local6\Field10))
        writefloat(local7, local6\Field11)
        writebyte(local7, local6\Field23)
        writebyte(local7, local6\Field24)
    Next
    writeint(local7, $735)
    debuglog("1845")
    local3 = $00
    For local10 = Each decals
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local10 = Each decals
        writeint(local7, local10\Field8)
        writefloat(local7, entityx(local10\Field0, $01))
        writefloat(local7, entityy(local10\Field0, $01))
        writefloat(local7, entityz(local10\Field0, $01))
        writefloat(local7, entitypitch(local10\Field0, $01))
        writefloat(local7, entityyaw(local10\Field0, $01))
        writefloat(local7, entityroll(local10\Field0, $01))
        writebyte(local7, local10\Field6)
        writeint(local7, local10\Field7)
        writefloat(local7, local10\Field2)
        writefloat(local7, local10\Field5)
        writefloat(local7, local10\Field4)
        writefloat(local7, local10\Field9)
        writefloat(local7, local10\Field10)
    Next
    local3 = $00
    For local11 = Each events
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local11 = Each events
        writestring(local7, local11\Field0)
        writefloat(local7, local11\Field2)
        writefloat(local7, local11\Field3)
        writefloat(local7, local11\Field4)
        writefloat(local7, entityx(local11\Field1\Field2, $00))
        writefloat(local7, entityz(local11\Field1\Field2, $00))
        writebyte(local7, local11\Field24)
        writestring(local7, local11\Field11)
    Next
    local3 = $00
    For local12 = Each items
        local3 = (local3 + $01)
    Next
    writeint(local7, local3)
    For local12 = Each items
        writestring(local7, local12\Field3\Field1)
        writestring(local7, local12\Field3\Field2)
        writestring(local7, local12\Field0)
        writefloat(local7, entityx(local12\Field1, $01))
        writefloat(local7, entityy(local12\Field1, $01))
        writefloat(local7, entityz(local12\Field1, $01))
        writebyte(local7, local12\Field5)
        writebyte(local7, local12\Field6)
        writebyte(local7, local12\Field7)
        writefloat(local7, local12\Field8)
        writefloat(local7, entitypitch(local12\Field1, $00))
        writefloat(local7, entityyaw(local12\Field1, $00))
        writefloat(local7, local12\Field13)
        writebyte(local7, local12\Field15)
        writebyte(local7, local12\Field22)
        If (selecteditem = local12) Then
            writebyte(local7, $01)
        Else
            writebyte(local7, $00)
        EndIf
        local13 = $00
        For local2 = $00 To $09 Step $01
            If (inventory(local2) = local12) Then
                local13 = $01
                Exit
            EndIf
        Next
        If (local13 <> 0) Then
            writebyte(local7, local2)
        Else
            writebyte(local7, $42)
        EndIf
        If (local12\Field3\Field13 <> $00) Then
            writefloat(local7, animtime(local12\Field2))
        EndIf
        writebyte(local7, local12\Field19)
        writeint(local7, local12\Field18)
        If (local12\Field3\Field8 = local12\Field16) Then
            writebyte(local7, $00)
        Else
            writebyte(local7, $01)
        EndIf
    Next
    writeint(local7, $11CF)
    If (usedconsole <> 0) Then
        writeint(local7, $64)
        debuglog("Used Console")
    Else
        writeint(local7, $3E2)
    EndIf
    writefloat(local7, camerafogfar)
    writefloat(local7, storedcamerafogfar)
    writebyte(local7, i_427\Field0)
    writefloat(local7, i_427\Field1)
    writebyte(local7, wearing714)
    local3 = $00
    For local12 = Each items
        If (local12\Field19 > $00) Then
            local3 = (local3 + $01)
        EndIf
    Next
    writeint(local7, local3)
    For local12 = Each items
        If (local12\Field19 > $00) Then
            writeint(local7, local12\Field18)
            For local2 = $00 To (local12\Field19 - $01) Step $01
                If (local12\Field17[local2] <> Null) Then
                    writeint(local7, local12\Field17[local2]\Field18)
                Else
                    writeint(local7, $FFFFFFFF)
                EndIf
            Next
        EndIf
    Next
    For local14 = Each itemtemplates
        writebyte(local7, local14\Field4)
    Next
    For local2 = $00 To $03 Step $01
        If (selecteddifficulty = difficulties(local2)) Then
            writebyte(local7, local2)
            If (local2 = $03) Then
                writebyte(local7, selecteddifficulty\Field3)
                writebyte(local7, selecteddifficulty\Field2)
                writebyte(local7, selecteddifficulty\Field4)
                writebyte(local7, selecteddifficulty\Field5)
            EndIf
            Exit
        EndIf
    Next
    closefile(local7)
    If (menuopen = $00) Then
        If (selecteddifficulty\Field4 = $02) Then
            playsound_strict(loadtempsound("SFX\General\Save2.ogg"))
        Else
            playsound_strict(loadtempsound("SFX\General\Save1.ogg"))
        EndIf
        msg = "Game progress saved."
        msgtimer = 280.0
    EndIf
    Return $00
End Function
