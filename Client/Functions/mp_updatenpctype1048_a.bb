Function mp_updatenpctype1048_a%(arg0.npcs)
    Local local0#
    Local local1%
    Local local3#
    Local local4#
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9%
    Local local10.decals
    If (arg0\Field50 = $00) Then
        local0 = entitydistancesquared(arg0\Field3, me\Field60)
        local1 = ((6.0 > local0) And entityvisible(arg0\Field3, me\Field60))
        If (local1 <> 0) Then
            giveachievement("1048", $01)
        EndIf
        arg0\Field23 = 1.0
        Select arg0\Field10
            Case 0.0
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                animatenpc(arg0, 2.0, 399.0, arg0\Field23, $01)
                If (rand($12C, $01) = $01) Then
                    If (channelplaying(arg0\Field18) = $00) Then
                        arg0\Field18 = playsoundex(loadtempsound((("SFX\SCP\1048A\Random" + (Str rand($00, $04))) + ".ogg")), camera, arg0\Field3, 8.0, 1.0, $01)
                    EndIf
                EndIf
                If ((local1 And ((chs\Field2 Lor i_268\Field2) = $00)) <> 0) Then
                    arg0\Field10 = 2.0
                EndIf
            Case 1.0
                arg0\Field23 = 0.008
                rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 10.0)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                animatenpc(arg0, 649.0, 677.0, (arg0\Field24 * 125.0), $01)
            Case 2.0
                local3 = arg0\Field14
                animatenpc(arg0, max(local3, 2.0), 647.0, 1.0, $00)
                If (((400.0 >= local3) And (400.0 < arg0\Field14)) <> 0) Then
                    arg0\Field18 = playsound_strict(loadtempsound("SFX\SCP\1048A\Shriek.ogg"), $00)
                EndIf
                local4 = max((1.0 - ((Abs (local3 - 600.0)) / 100.0)), 0.0)
                me\Field49 = ((local4 * 1000.0) / max((local0 / 8.0), 1.0))
                me\Field23 = ((local4 * 10.0) / max((local0 / 4.0), 1.0))
                If ((chs\Field2 Lor i_268\Field2) = $00) Then
                    pointentity(arg0\Field3, me\Field60, 0.0)
                    rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
                EndIf
                arg0\Field15 = curveangle(entityyaw(arg0\Field3, $01), arg0\Field15, 20.0)
                If (646.0 < local3) Then
                    If ((((16.0 > local0) And (0.0 = i_1048a\Field0)) And (me\Field54 = $00)) <> 0) Then
                        i_1048a\Field2 = playsound_strict(loadtempsound("SFX\SCP\1048A\Growth.ogg"), $01)
                        me\Field49 = 1000.0
                        me\Field23 = 2.0
                        i_1048a\Field0 = 0.01
                    EndIf
                    arg0\Field60 = $00
                EndIf
        End Select
        updatesoundorigin(arg0\Field18, camera, arg0\Field3, 8.0, 1.0, $01, $01)
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.15), entityz(arg0\Field3, $00), $00)
        rotateentity(arg0\Field0, -89.9, arg0\Field15, 0.0, $00)
        If (arg0\Field60 <= $00) Then
            playsoundex(loadtempsound("SFX\SCP\1048A\Explode.ogg"), camera, arg0\Field3, 8.0, 1.0, $00)
            local6 = entityx(arg0\Field3, $00)
            local7 = entityy(arg0\Field3, $00)
            local8 = entityz(arg0\Field3, $00)
            For local5 = $00 To $01 Step $01
                setemitter(Null, local6, local7, local8, $0F)
                setemitter(Null, local6, local7, local8, $15)
            Next
            local9 = createpivot($00)
            positionentity(local9, (rnd(-0.05, 0.05) + local6), (local7 - 0.05), (rnd(-0.05, 0.05) + local8), $00)
            turnentity(local9, 90.0, 0.0, 0.0, $00)
            If (entitypick(local9, 0.3) <> 0) Then
                local10 = createdecal(rand($10, $11), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, rnd(0.3, 0.5), 1.0, $00, $01, $00, $00, $00)
                local10\Field4 = rnd(0.001, 0.0015)
                local10\Field5 = (local10\Field3 + rnd(0.008, 0.009))
            EndIf
            arg0\Field50 = $01
        EndIf
    EndIf
    Return $00
End Function
