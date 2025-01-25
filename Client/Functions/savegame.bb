Function savegame%(arg0$)
    Local local0.npcs
    Local local1.rooms
    Local local2.doors
    Local local3.emitter
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    Local local12.decals
    Local local13.events
    Local local14.items
    Local local15%
    Local local16.itemtemplates
    If ((me\Field56 Lor (Int me\Field0)) <> 0) Then
        Return $00
    EndIf
    If ((((fps\Field7[$00] * 0.02) < me\Field36) Lor ((fps\Field7[$00] * -0.02) > me\Field36)) <> 0) Then
        Return $00
    EndIf
    catcherrors((("SaveGame(" + arg0) + ")"))
    gamesaved = $01
    arg0 = ("Saves\" + arg0)
    createdir(arg0)
    local8 = writefile((arg0 + "\save.cb"))
    writestring(local8, currenttime())
    writestring(local8, currentdate())
    writestring(local8, "1.5")
    If (selectedcustommap = Null) Then
        writebyte(local8, $00)
        writestring(local8, randomseed)
    Else
        writebyte(local8, $01)
        writestring(local8, selectedcustommap\Field0)
    EndIf
    writestring(local8, selecteddifficulty\Field0)
    writeint(local8, code_dr_maynard)
    writeint(local8, code_o5_council)
    writeint(local8, code_maintenance_tunnels)
    writeint(local8, code_dr_gears)
    writefloat(local8, entityx(me\Field60, $00))
    writefloat(local8, entityy(me\Field60, $00))
    writefloat(local8, entityz(me\Field60, $00))
    writefloat(local8, entityx(me\Field61, $00))
    writefloat(local8, entityy(me\Field61, $00))
    writefloat(local8, entityz(me\Field61, $00))
    writefloat(local8, entitypitch(me\Field60, $00))
    writefloat(local8, entityyaw(me\Field60, $00))
    writefloat(local8, me\Field10)
    writefloat(local8, me\Field11)
    writefloat(local8, me\Field12)
    writefloat(local8, me\Field13)
    writefloat(local8, me\Field49)
    writefloat(local8, me\Field35)
    writebyte(local8, me\Field39)
    writefloat(local8, me\Field17)
    writefloat(local8, me\Field18)
    writefloat(local8, me\Field19)
    writefloat(local8, me\Field15)
    writefloat(local8, me\Field14)
    writefloat(local8, me\Field31)
    writefloat(local8, me\Field32)
    writefloat(local8, me\Field33)
    writefloat(local8, me\Field34)
    writestring(local8, msg\Field2)
    writeint(local8, me\Field64)
    writebyte(local8, me\Field65)
    writefloat(local8, me\Field26)
    writebyte(local8, me\Field25)
    writefloat(local8, me\Field21)
    writefloat(local8, me\Field23)
    writefloat(local8, me\Field24)
    writefloat(local8, me\Field50)
    writefloat(local8, me\Field51)
    writefloat(local8, me\Field5)
    writeint(local8, me\Field53)
    writebyte(local8, i_005\Field0)
    writebyte(local8, i_500\Field0)
    For local6 = $00 To $06 Step $01
        writefloat(local8, i_1025\Field0[local6])
    Next
    For local6 = $00 To $04 Step $01
        writefloat(local8, i_1025\Field1[local6])
    Next
    writefloat(local8, i_008\Field0)
    writebyte(local8, i_008\Field1)
    writefloat(local8, i_409\Field0)
    writebyte(local8, i_409\Field1)
    writebyte(local8, i_035\Field0)
    For local6 = $00 To $04 Step $01
        If (selecteddifficulty = difficulties[local6]) Then
            writebyte(local8, local6)
            If (local6 = $04) Then
                writebyte(local8, selecteddifficulty\Field2)
                writebyte(local8, selecteddifficulty\Field3)
                writebyte(local8, selecteddifficulty\Field4)
                writebyte(local8, selecteddifficulty\Field9)
            EndIf
        EndIf
    Next
    writefloat(local8, wi\Field1)
    writebyte(local8, wi\Field0)
    writebyte(local8, wi\Field3)
    writebyte(local8, wi\Field4)
    writebyte(local8, wi\Field2)
    writebyte(local8, wi\Field5)
    writebyte(local8, wi\Field9)
    writebyte(local8, i_1499\Field0)
    writefloat(local8, i_1499\Field1)
    writefloat(local8, i_1499\Field2)
    writefloat(local8, i_1499\Field3)
    writefloat(local8, i_1499\Field5)
    writefloat(local8, i_1499\Field6)
    writefloat(local8, i_1499\Field7)
    If (i_1499\Field4 <> Null) Then
        writefloat(local8, i_1499\Field4\Field3)
        writefloat(local8, i_1499\Field4\Field5)
    Else
        writefloat(local8, 0.0)
        writefloat(local8, 0.0)
    EndIf
    writefloat(local8, i_966\Field1)
    writefloat(local8, i_966\Field0)
    writefloat(local8, i_1048a\Field0)
    writebyte(local8, i_1048a\Field1)
    writebyte(local8, i_268\Field0)
    writefloat(local8, i_268\Field1)
    writebyte(local8, i_427\Field0)
    writefloat(local8, i_427\Field1)
    writebyte(local8, i_714\Field0)
    writebyte(local8, i_294\Field0)
    writestring(local8, randomseed)
    writefloat(local8, secondarylighton)
    writefloat(local8, lightvolume)
    writebyte(local8, isblackout)
    writebyte(local8, previsblackout)
    writebyte(local8, remotedooron)
    writebyte(local8, soundtransmission)
    writebyte(local8, key2_spawnrate)
    local9 = jsongetarray(jsongetvalue(achievementsarray, "achievements"))
    local10 = jsongetarraysize(local9)
    For local6 = $00 To (local10 - $01) Step $01
        local11 = jsongetstring(jsongetvalue(jsongetarrayvalue(local9, local6), "id"))
        If (s2imapcontains(unlockedachievements, local11) <> 0) Then
            writestring(local8, local11)
        EndIf
    Next
    writestring(local8, "EOA")
    writebyte(local8, usedconsole)
    writefloat(local8, mtftimer)
    writefloat(local8, remove714timer)
    writefloat(local8, removehazmattimer)
    For local4 = $00 To $15 Step $01
        For local5 = $00 To $15 Step $01
            writebyte(local8, currmapgrid\Field0[((local5 * $15) + local4)])
            writebyte(local8, currmapgrid\Field2[((local5 * $15) + local4)])
        Next
    Next
    writeint(local8, $71)
    local7 = $00
    For local0 = Each npcs
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local0 = Each npcs
        writebyte(local8, local0\Field4)
        writefloat(local8, entityx(local0\Field3, $01))
        writefloat(local8, entityy(local0\Field3, $01))
        writefloat(local8, entityz(local0\Field3, $01))
        writefloat(local8, entitypitch(local0\Field3, $00))
        writefloat(local8, entityyaw(local0\Field3, $00))
        writefloat(local8, entityroll(local0\Field3, $00))
        writefloat(local8, local0\Field10)
        writefloat(local8, local0\Field11)
        writefloat(local8, local0\Field12)
        writeint(local8, local0\Field13)
        writebyte(local8, (Int local0\Field26))
        writefloat(local8, local0\Field30)
        writeint(local8, local0\Field29)
        writefloat(local8, local0\Field24)
        writefloat(local8, local0\Field15)
        writefloat(local8, local0\Field28)
        writeint(local8, local0\Field5)
        If (local0\Field34 <> Null) Then
            writeint(local8, local0\Field34\Field5)
        Else
            writeint(local8, $00)
        EndIf
        writefloat(local8, local0\Field36)
        writefloat(local8, local0\Field37)
        writefloat(local8, local0\Field38)
        writestring(local8, local0\Field25)
        writebyte(local8, local0\Field63)
        writebyte(local8, local0\Field64)
        If (local0\Field64 <> 0) Then
            writefloat(local8, animtime(local0\Field0))
        EndIf
        writebyte(local8, local0\Field65)
        writebyte(local8, local0\Field50)
        writeint(local8, local0\Field60)
        writefloat(local8, local0\Field61)
        writebyte(local8, local0\Field62)
        writebyte(local8, local0\Field43)
    Next
    writeint(local8, $278)
    writebyte(local8, i_zone\Field0[$00])
    writebyte(local8, i_zone\Field0[$01])
    writebyte(local8, i_zone\Field1)
    writebyte(local8, i_zone\Field2)
    local7 = $00
    For local1 = Each rooms
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local1 = Each rooms
        writeint(local8, local1\Field7\Field1)
        writeint(local8, local1\Field6)
        writefloat(local8, local1\Field3)
        writefloat(local8, local1\Field4)
        writefloat(local8, local1\Field5)
        writebyte(local8, local1\Field1)
        writeint(local8, local1\Field0)
        writebyte(local8, (playerroom = local1))
        For local6 = $00 To $0B Step $01
            If (local1\Field15[local6] = Null) Then
                writeint(local8, $00)
            Else
                writeint(local8, local1\Field15[local6]\Field5)
            EndIf
        Next
        For local6 = $00 To $03 Step $01
            If (local1\Field13[local6] = Null) Then
                writebyte(local8, $02)
            Else
                writebyte(local8, (0.0 >= entitypitch(local1\Field13[local6]\Field0, $01)))
            EndIf
        Next
        If (local1\Field18 = Null) Then
            writebyte(local8, $00)
        Else
            writebyte(local8, $01)
            For local5 = $00 To $12 Step $01
                For local4 = $00 To $12 Step $01
                    writebyte(local8, local1\Field18\Field0[((local5 * $13) + local4)])
                    writebyte(local8, local1\Field18\Field1[((local5 * $13) + local4)])
                Next
            Next
        EndIf
        If (local1\Field10 = Null) Then
            writebyte(local8, $00)
        Else
            If (i_zone\Field1 <> 0) Then
                writebyte(local8, $02)
            Else
                writebyte(local8, $01)
            EndIf
            For local5 = $00 To $09 Step $01
                For local4 = $00 To $09 Step $01
                    writebyte(local8, local1\Field10\Field2[((local5 * $0A) + local4)])
                Next
            Next
            writefloat(local8, entityx(local1\Field10\Field4, $01))
            writefloat(local8, entityy(local1\Field10\Field4, $01))
            writefloat(local8, entityz(local1\Field10\Field4, $01))
        EndIf
    Next
    writeint(local8, $3BA)
    local7 = $00
    For local3 = Each emitter
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local3 = Each emitter
        writefloat(local8, entityx(local3\Field6, $01))
        writefloat(local8, entityy(local3\Field6, $01))
        writefloat(local8, entityz(local3\Field6, $01))
        writeint(local8, local3\Field4)
        writebyte(local8, local3\Field11)
        writeint(local8, local3\Field5)
    Next
    For local1 = Each rooms
        For local6 = $00 To $07 Step $01
            If (local1\Field17[local6] = Null) Then
                writeint(local8, $00)
            Else
                writeint(local8, local1\Field17[local6]\Field5)
            EndIf
        Next
    Next
    writebyte(local8, bk\Field0)
    writefloat(local8, bk\Field1)
    writefloat(local8, bk\Field2)
    local7 = $00
    For local2 = Each doors
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local2 = Each doors
        writefloat(local8, entityx(local2\Field2, $01))
        writefloat(local8, entityy(local2\Field2, $01))
        writefloat(local8, entityz(local2\Field2, $01))
        writebyte(local8, local2\Field6)
        writefloat(local8, local2\Field8)
        writebyte(local8, local2\Field4)
        writebyte(local8, local2\Field20)
        writefloat(local8, entityx(local2\Field0, $01))
        writefloat(local8, entityz(local2\Field0, $01))
        writefloat(local8, entityyaw(local2\Field0, $01))
        If (local2\Field1 <> $00) Then
            writefloat(local8, entityx(local2\Field1, $01))
            writefloat(local8, entityz(local2\Field1, $01))
        Else
            writefloat(local8, 0.0)
            writefloat(local8, 0.0)
        EndIf
        writefloat(local8, (Float local2\Field12))
        writefloat(local8, local2\Field13)
        writebyte(local8, local2\Field22)
        writebyte(local8, local2\Field23)
        writebyte(local8, local2\Field27)
    Next
    writeint(local8, $735)
    local7 = $00
    For local12 = Each decals
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local12 = Each decals
        writeint(local8, local12\Field2)
        writefloat(local8, entityx(local12\Field0, $01))
        writefloat(local8, entityy(local12\Field0, $01))
        writefloat(local8, entityz(local12\Field0, $01))
        writefloat(local8, entitypitch(local12\Field0, $01))
        writefloat(local8, entityyaw(local12\Field0, $01))
        writefloat(local8, entityroll(local12\Field0, $01))
        writefloat(local8, local12\Field3)
        writefloat(local8, local12\Field5)
        writefloat(local8, local12\Field6)
        writebyte(local8, local12\Field9)
        writebyte(local8, local12\Field8)
        writebyte(local8, local12\Field10)
        writebyte(local8, local12\Field11)
        writebyte(local8, local12\Field12)
        writefloat(local8, local12\Field13)
        writefloat(local8, local12\Field14)
        writefloat(local8, local12\Field4)
        writefloat(local8, local12\Field7)
    Next
    local7 = $00
    For local13 = Each events
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local13 = Each events
        writebyte(local8, local13\Field0)
        writefloat(local8, local13\Field2)
        writefloat(local8, local13\Field3)
        writefloat(local8, local13\Field4)
        writefloat(local8, local13\Field5)
        writefloat(local8, entityx(local13\Field1\Field2, $00))
        writefloat(local8, entityz(local13\Field1\Field2, $00))
        writestring(local8, local13\Field13)
    Next
    local7 = $00
    For local14 = Each items
        local7 = (local7 + $01)
    Next
    writeint(local8, local7)
    For local14 = Each items
        writestring(local8, local14\Field4\Field1)
        writeint(local8, local14\Field4\Field2)
        writestring(local8, local14\Field1)
        writestring(local8, local14\Field0)
        writefloat(local8, entityx(local14\Field2, $01))
        writefloat(local8, entityy(local14\Field2, $01))
        writefloat(local8, entityz(local14\Field2, $01))
        writebyte(local8, local14\Field6)
        writebyte(local8, local14\Field7)
        writebyte(local8, local14\Field8)
        writefloat(local8, local14\Field9)
        writefloat(local8, entitypitch(local14\Field2, $00))
        writefloat(local8, entityyaw(local14\Field2, $00))
        writefloat(local8, local14\Field12)
        writefloat(local8, local14\Field13)
        writefloat(local8, local14\Field14)
        writebyte(local8, local14\Field15)
        writebyte(local8, (selecteditem = local14))
        local15 = $00
        For local6 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local6) = local14) Then
                local15 = $01
                Exit
            EndIf
        Next
        If (local15 <> 0) Then
            writebyte(local8, local6)
        Else
            writebyte(local8, $42)
        EndIf
        If (local14\Field4\Field17 <> 0) Then
            writefloat(local8, animtime(local14\Field3))
        EndIf
        writebyte(local8, local14\Field20)
        writeint(local8, local14\Field19)
        writebyte(local8, (local14\Field4\Field7 <> local14\Field17))
    Next
    local7 = $00
    For local14 = Each items
        If (local14\Field20 > $00) Then
            local7 = (local7 + $01)
        EndIf
    Next
    writeint(local8, local7)
    For local14 = Each items
        If (local14\Field20 > $00) Then
            writeint(local8, local14\Field19)
            For local6 = $00 To (local14\Field20 - $01) Step $01
                If (local14\Field18[local6] <> Null) Then
                    writeint(local8, local14\Field18[local6]\Field19)
                Else
                    writeint(local8, $FFFFFFFF)
                EndIf
            Next
        EndIf
    Next
    For local16 = Each itemtemplates
        writebyte(local8, local16\Field4)
    Next
    For local3 = Each emitter
        For local1 = Each rooms
            writebyte(local8, (local3\Field10 = local1))
        Next
    Next
    writeint(local8, escapetimer)
    closefile(local8)
    If (selecteddifficulty\Field3 = $01) Then
        playsound_strict(loadtempsound("SFX\General\Save1.ogg"), $00)
    Else
        playsound_strict(loadtempsound("SFX\General\Save0.ogg"), $00)
        as\Field1 = 8400.0
    EndIf
    createhintmsg(getlocalstring("save", "saved"), 6.0, $00)
    catcherrors((("Uncaught: SaveGame(" + arg0) + ")"))
    Return $00
End Function
