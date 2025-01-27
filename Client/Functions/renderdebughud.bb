Function renderdebughud%()
    Local local0.events
    Local local1.chunk
    Local local2.rooms
    Local local3%
    Local local4%
    Local local5%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    local3 = (Int (20.0 * menuscale))
    local4 = (Int (40.0 * menuscale))
    color($FF, $FF, $FF)
    setfontex(fo\Field0[$05])
    Select chs\Field8
        Case $01
            textex(local3, local4, format(getlocalstring("misc", "room"), ((("ID: " + (Str playerroom\Field7\Field6)) + "; Name: ") + playerroom\Field7\Field5), "%s"), $00, $00)
            textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_1.xyz"), (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5))), "{0}"), (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5))), "{1}"), (Str playerroom\Field6), "{2}"), $00, $00)
            For local0 = Each events
                If (local0\Field1 = playerroom) Then
                    textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.event_new"), (Str local0\Field0), "%s"), $00, $00)
                    textex(local3, (Int ((60.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.state_1"), (Str local0\Field2), "%s"), $00, $00)
                    textex(local3, (Int ((80.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.state_2"), (Str local0\Field3), "%s"), $00, $00)
                    textex(local3, (Int ((100.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.state_3"), (Str local0\Field4), "%s"), $00, $00)
                    textex(local3, (Int ((120.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.state_4"), (Str local0\Field5), "%s"), $00, $00)
                    textex(local3, (Int ((140.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.str"), local0\Field13, "%s"), $00, $00)
                    Exit
                EndIf
            Next
            If (playerroom\Field7\Field6 = $6A) Then
                textex(local3, (Int ((180.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_1.chunkxyz"), (Str (Int ((entityx(me\Field60, $00) + 20.0) / 40.0))), "{0}"), (Str (Int ((entityz(me\Field60, $00) + 20.0) / 40.0))), "{1}"), $00, $00)
                local7 = $00
                For local1 = Each chunk
                    local7 = (local7 + $01)
                Next
                textex(local3, (Int ((200.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.currchunk"), (Str local7), "%s"), $00, $00)
            Else
                textex(local3, (Int ((200.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_1.currroom"), (Str playerroom\Field3), "{0}"), (Str playerroom\Field4), "{1}"), (Str playerroom\Field5), "{2}"), $00, $00)
            EndIf
            If (sc_i\Field3 = Null) Then
                textex(local3, (Int ((240.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.currmon"), "Null", "%s"), $00, $00)
            EndIf
            If (selecteditem <> Null) Then
                textex(local3, (Int ((280.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.curritem"), ((("ID: " + (Str selecteditem\Field4\Field2)) + "; Name: ") + selecteditem\Field4\Field1), "%s"), $00, $00)
            ElseIf (d_i\Field9 = $00) Then
                textex(local3, (Int ((280.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.currbtn"), "Null", "%s"), $00, $00)
            EndIf
            textex(local3, (Int ((320.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.currflo"), (Str infacility), "%s"), $00, $00)
            textex(local3, (Int ((340.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.roomflo"), (Str toelevatorfloor), "%s"), $00, $00)
            textex(local3, (Int ((360.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.inelev"), (Str me\Field66), "%s"), $00, $00)
            textex(local3, (Int ((400.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_1.time"), currentdate(), "{0}"), currenttime(), "{1}"), $00, $00)
            textex(local3, (Int ((420.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_1.vidmem"), (Str (opt\Field57 - (availvidmem() Sar $0A))), "{0}"), (Str opt\Field57), "{1}"), $00, $00)
            textex(local3, (Int ((440.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_1.glomem"), (Str (opt\Field58 - (availphys() Sar $0A))), "{0}"), (Str opt\Field58), "{1}"), $00, $00)
            textex(local3, (Int ((460.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.triamo"), (Str currtrisamount), "%s"), $00, $00)
            textex(local3, (Int ((480.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_1.acttex"), (Str activetextures()), "%s"), $00, $00)
        Case $02
            tformpoint(entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00, playerroom\Field2)
            textex(local3, local4, format(format(format(getlocalstring("console", "debug_2.ppos"), floattostring(tformedx(), $01), "{0}"), floattostring(tformedy(), $01), "{1}"), floattostring(tformedz(), $01), "{2}"), $00, $00)
            textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_2.pcampos"), floattostring(entityx(camera, $00), $01), "{0}"), floattostring(entityy(camera, $00), $01), "{1}"), floattostring(entityz(camera, $00), $01), "{2}"), $00, $00)
            textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_2.prot"), floattostring(entitypitch(me\Field60, $00), $01), "{0}"), floattostring(entityyaw(me\Field60, $00), $01), "{1}"), floattostring(entityroll(me\Field60, $00), $01), "{2}"), $00, $00)
            textex(local3, (Int ((80.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.injuries"), (Str me\Field31), "%s"), $00, $00)
            textex(local3, (Int ((100.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.bloodloss"), (Str me\Field32), "%s"), $00, $00)
            textex(local3, (Int ((140.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.blur"), (Str me\Field49), "%s"), $00, $00)
            textex(local3, (Int ((160.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.blink"), (Str me\Field50), "%s"), $00, $00)
            textex(local3, (Int ((180.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.flash"), (Str me\Field51), "%s"), $00, $00)
            textex(local3, (Int ((220.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.freq"), (Str me\Field11), "%s"), $00, $00)
            textex(local3, (Int ((240.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.timer"), (Str me\Field10), "%s"), $00, $00)
            textex(local3, (Int ((260.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.effect"), (Str me\Field12), "%s"), $00, $00)
            textex(local3, (Int ((280.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.efftim"), (Str me\Field13), "%s"), $00, $00)
            textex(local3, (Int ((300.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.eyeirr"), (Str me\Field14), "%s"), $00, $00)
            textex(local3, (Int ((320.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.eyestuck"), (Str me\Field15), "%s"), $00, $00)
            textex(local3, (Int ((360.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.stamina"), (Str me\Field17), "%s"), $00, $00)
            textex(local3, (Int ((380.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.stameff"), (Str me\Field18), "%s"), $00, $00)
            textex(local3, (Int ((400.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.stamtimer"), (Str me\Field19), "%s"), $00, $00)
            textex(local3, (Int ((440.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.deaf"), (Str me\Field55), "%s"), $00, $00)
            textex(local3, (Int ((460.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.sanity"), (Str me\Field5), "%s"), $00, $00)
            local3 = (Int ((700.0 * menuscale) + (Float local3)))
            textex(local3, local4, format(getlocalstring("console", "debug_2.terminated"), (Str me\Field0), "%s"), $00, $00)
            textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.death"), (Str me\Field4), "%s"), $00, $00)
            textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.fall"), (Str me\Field3), "%s"), $00, $00)
            textex(local3, (Int ((80.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.heal"), (Str me\Field35), "%s"), $00, $00)
            textex(local3, (Int ((120.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.heartbeat"), (Str me\Field29), "%s"), $00, $00)
            textex(local3, (Int ((160.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.explosion"), (Str me\Field58), "%s"), $00, $00)
            textex(local3, (Int ((200.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.speed"), (Str me\Field38), "%s"), $00, $00)
            textex(local3, (Int ((240.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.camshake"), (Str me\Field21), "%s"), $00, $00)
            textex(local3, (Int ((260.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.camzoom"), (Str me\Field52), "%s"), $00, $00)
            textex(local3, (Int ((300.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.vomit"), (Str me\Field26), "%s"), $00, $00)
            textex(local3, (Int ((340.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.playable"), (Str me\Field9), "%s"), $00, $00)
            textex(local3, (Int ((380.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.refitems"), (Str me\Field53), "%s"), $00, $00)
            textex(local3, (Int ((400.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.itemamount"), (Str getitemamount()), "%s"), $00, $00)
            textex(local3, (Int ((440.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_2.escape"), (Str escapetimer), "%s"), $00, $00)
        Case $03
            If (n_i\Field6 <> Null) Then
                textex(local3, local4, format(format(format(getlocalstring("console", "debug_3.049pos"), floattostring(entityx(n_i\Field6\Field0, $00), $02), "{0}"), floattostring(entityy(n_i\Field6\Field0, $00), $02), "{1}"), floattostring(entityz(n_i\Field6\Field0, $00), $02), "{2}"), $00, $00)
                textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.049idle"), (Str n_i\Field6\Field26), "%s"), $00, $00)
                textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.049state"), (Str n_i\Field6\Field10), "%s"), $00, $00)
            EndIf
            If (n_i\Field4 <> Null) Then
                textex(local3, (Int ((60.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_3.096pos"), floattostring(entityx(n_i\Field4\Field0, $00), $02), "{0}"), floattostring(entityy(n_i\Field4\Field0, $00), $02), "{1}"), floattostring(entityz(n_i\Field4\Field0, $00), $02), "{2}"), $00, $00)
                textex(local3, (Int ((80.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.096idle"), (Str n_i\Field4\Field26), "%s"), $00, $00)
                textex(local3, (Int ((100.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.096state"), (Str n_i\Field4\Field10), "%s"), $00, $00)
            EndIf
            textex(local3, (Int ((120.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_3.106pos"), floattostring(entityx(n_i\Field3\Field0, $00), $02), "{0}"), floattostring(entityy(n_i\Field3\Field0, $00), $02), "{1}"), floattostring(entityz(n_i\Field3\Field0, $00), $02), "{2}"), $00, $00)
            textex(local3, (Int ((140.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.106idle"), (Str n_i\Field3\Field26), "%s"), $00, $00)
            textex(local3, (Int ((160.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_3.106state"), "1", "{0}"), (Str n_i\Field3\Field10), "{1}"), $00, $00)
            textex(local3, (Int ((180.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_3.106state"), "2", "{0}"), (Str n_i\Field3\Field11), "{1}"), $00, $00)
            textex(local3, (Int ((200.0 * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_3.106state"), "3", "{0}"), (Str n_i\Field3\Field12), "{1}"), $00, $00)
            textex(local3, (Int ((220.0 * menuscale) + (Float local4))), format(format(format(getlocalstring("console", "debug_3.173pos"), floattostring(entityx(n_i\Field2\Field0, $00), $02), "{0}"), floattostring(entityy(n_i\Field2\Field0, $00), $02), "{1}"), floattostring(entityz(n_i\Field2\Field0, $00), $02), "{2}"), $00, $00)
            textex(local3, (Int ((240.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.173idle"), (Str n_i\Field2\Field26), "%s"), $00, $00)
            textex(local3, (Int ((260.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.173state"), (Str n_i\Field2\Field10), "%s"), $00, $00)
            textex(local3, (Int ((300.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.pill"), (Str i_500\Field0), "%s"), $00, $00)
            textex(local3, (Int ((340.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.008"), (Str i_008\Field0), "%s"), $00, $00)
            textex(local3, (Int ((360.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.409"), (Str i_409\Field0), "%s"), $00, $00)
            textex(local3, (Int ((380.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.427"), (Str (i_427\Field1 / 70.0)), "%s"), $00, $00)
            textex(local3, (Int ((400.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.966"), (Str (i_966\Field0 / 70.0)), "%s"), $00, $00)
            textex(local3, (Int ((420.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.1048a"), (Str i_1048a\Field0), "%s"), $00, $00)
            For local5 = $00 To $06 Step $01
                textex(local3, (Int (((Float (($14 * local5) + $1B8)) * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_3.1025"), (Str local5), "{0}"), (Str i_1025\Field0[local5]), "{1}"), $00, $00)
            Next
            For local5 = $00 To $04 Step $01
                textex(local3, (Int (((Float (($14 * local5) + $244)) * menuscale) + (Float local4))), format(format(getlocalstring("console", "debug_3.f.1025"), (Str local5), "{0}"), (Str i_1025\Field1[local5]), "{1}"), $00, $00)
            Next
            local3 = (Int ((700.0 * menuscale) + (Float local3)))
            If (i_005\Field0 = $01) Then
                textex(local3, local4, getlocalstring("console", "debug_3.005.chamber"), $00, $00)
            ElseIf (i_005\Field0 = $02) Then
                textex(local3, local4, getlocalstring("console", "debug_3.005.409"), $00, $00)
            Else
                textex(local3, local4, getlocalstring("console", "debug_3.005.maynard"), $00, $00)
            EndIf
            local8 = (Int max((Float ((((s2imapsize(achievementsindex) - $03) - (s2imapsize(unlockedachievements) - $01)) - s2imapcontains(unlockedachievements, "apollyon")) * (selecteddifficulty\Field4 + $04))), 0.0))
            textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.OmniChance.Any"), (Str (local8 + $01)), "%s"), $00, $00)
            textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.OmniChance.5"), (Str ((local8 Sar $01) + $01)), "%s"), $00, $00)
            local9 = $00
            local10 = $00
            For local2 = Each rooms
                local11 = local2\Field7\Field6
                If ((((((local11 <> $04) And (local11 <> $47)) And (local11 <> $49)) And (local11 <> $69)) And (local11 <> $6A)) <> 0) Then
                    local9 = (local9 + $01)
                    local10 = (local10 + local2\Field1)
                EndIf
            Next
            textex(local3, (Int ((60.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_3.NavUltiChance"), (Str (Int max((Float ((local9 - (local10 Shl $01)) * (selecteddifficulty\Field4 + $01))), 1.0))), "%s"), $00, $00)
        Case $04
            textex(local3, (Int ((20.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_4.MultiplayerIP"), (Str ue_server\Field3), "%s"), $00, $00)
            textex(local3, (Int ((40.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_4.MultiplayerID"), (Str mp_getmyindex()), "%s"), $00, $00)
            textex(local3, (Int ((60.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_4.MultiplayerNR"), (((Str ((Float mp_getnetworkrate()) / 1024.0)) + " ") + getlocalstring("console", "debug_4.MultiplayerNR_kb")), "%s"), $00, $00)
            textex(local3, (Int ((80.0 * menuscale) + (Float local4))), format(getlocalstring("console", "debug_4.MultiplayerObj"), (Str mp_getdynamicobjectscount()), "%s"), $00, $00)
    End Select
    setfontex(fo\Field0[$00])
    Return $00
End Function
