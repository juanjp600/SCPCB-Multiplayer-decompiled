Function mp_updatenpctype513_1%(arg0.npcs)
    Local local0.waypoints
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    If (playerinreachableroom($01, $00) <> 0) Then
        Return $00
    EndIf
    If (1.0 = arg0\Field26) Then
        If (entityhidden(arg0\Field0) = $00) Then
            hideentity(arg0\Field0)
            hideentity(arg0\Field1)
        EndIf
        If (rand($C8, $01) = $01) Then
            For local0 = Each waypoints
                If (local0\Field2 <> playerroom) Then
                    local1 = distancesquared(entityx(me\Field60, $00), entityx(local0\Field0, $01), entityz(me\Field60, $00), entityz(local0\Field0, $01), 0.0, 0.0)
                    If (((9.0 < local1) And (81.0 > local1)) <> 0) Then
                        positionentity(arg0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) + (1.0 / 12.8)), entityz(local0\Field0, $01), $00)
                        resetentity(arg0\Field3)
                        arg0\Field29 = $00
                        arg0\Field39[$00] = local0
                        arg0\Field26 = 0.0
                        arg0\Field11 = (rnd(15.0, 20.0) * 70.0)
                        arg0\Field10 = max((Float rand($FFFFFFFF, $02)), 0.0)
                        arg0\Field13 = rand($00, $01)
                        Exit
                    EndIf
                EndIf
            Next
        EndIf
    EndIf
    If (0.0 = arg0\Field26) Then
        If (entityhidden(arg0\Field0) <> 0) Then
            showentity(arg0\Field0)
            showentity(arg0\Field1)
        EndIf
        local1 = entitydistancesquared(me\Field60, arg0\Field3)
        arg0\Field31 = curvevalue(0.0, arg0\Field31, 10.0)
        arg0\Field33 = curvevalue(0.0, arg0\Field33, 10.0)
        If (rand($64, $01) = $01) Then
            If (rand($05, $01) = $01) Then
                arg0\Field31 = ((entityx(me\Field60, $00) - entityx(arg0\Field3, $00)) * 0.9)
                arg0\Field33 = ((entityz(me\Field60, $00) - entityz(arg0\Field3, $00)) * 0.9)
            Else
                arg0\Field31 = rnd(0.1, 0.5)
                arg0\Field33 = rnd(0.1, 0.5)
            EndIf
        EndIf
        local2 = rnd(-1.0, 1.0)
        positionentity(arg0\Field1, (entityx(arg0\Field3, $00) + (arg0\Field31 * local2)), ((entityy(arg0\Field3, $00) - 0.2) + (sin((Float (((millisec Sar $03) - $2D) Mod $168))) * 0.05)), (entityz(arg0\Field3, $00) + (arg0\Field33 * local2)), $00)
        rotateentity(arg0\Field1, 0.0, entityyaw(arg0\Field0, $00), 0.0, $00)
        If (floor(arg0\Field14) <> floor(animtime(arg0\Field1))) Then
            setanimtime(arg0\Field1, arg0\Field14, $00)
        EndIf
        If (0.0 = arg0\Field10) Then
            If (arg0\Field13 = $00) Then
                animatenpc(arg0, 2.0, 74.0, 0.2, $01)
            Else
                animatenpc(arg0, 75.0, 124.0, 0.2, $01)
            EndIf
            If (arg0\Field29 <> 0) Then
                pointentity(arg0\Field1, me\Field60, 0.0)
                rotateentity(arg0\Field0, 0.0, curveangle(entityyaw(arg0\Field1, $00), entityyaw(arg0\Field0, $00), 40.0), 0.0, $00)
                If (16.0 > local1) Then
                    arg0\Field10 = (Float rand($01, $02))
                EndIf
            ElseIf (((36.0 > local1) And (rand($05, $01) = $01)) <> 0) Then
                If ((entityinview(arg0\Field3, camera) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
                    arg0\Field29 = $01
                    me\Field5 = min(-450.0, me\Field5)
                    me\Field23 = 0.7
                    me\Field30 = 0.7
                    me\Field28 = 150.0
                    playsound_strict(loadtempsound((("SFX\SCP\513_1\Bell" + (Str rand($00, $02))) + ".ogg")), $00, $01)
                EndIf
            EndIf
        ElseIf (arg0\Field39[$00] = Null) Then
            For local0 = Each waypoints
                local3 = distancesquared(entityx(arg0\Field3, $00), entityx(local0\Field0, $00), entityz(arg0\Field3, $00), entityz(local0\Field0, $00), 0.0, 0.0)
                If (((64.0 > local3) And (1.0 < local3)) <> 0) Then
                    If (local1 < entitydistancesquared(me\Field60, local0\Field0)) Then
                        arg0\Field39[$00] = local0
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field39[$00] = Null) Then
                arg0\Field26 = 1.0
                arg0\Field11 = 0.0
            EndIf
        ElseIf (1.0 < entitydistancesquared(arg0\Field3, arg0\Field39[$00]\Field0)) Then
            pointentity(arg0\Field0, arg0\Field39[$00]\Field0, 0.0)
            rotateentity(arg0\Field3, curveangle(entitypitch(arg0\Field0, $00), entitypitch(arg0\Field3, $00), 15.0), curveangle(entityyaw(arg0\Field0, $00), entityyaw(arg0\Field3, $00), 15.0), 0.0, $01)
            arg0\Field24 = curvevalue((max(((7.0 - sqr(local1)) / 7.0), 0.0) * 0.05), arg0\Field24, 15.0)
            moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
            If (rand($C8, $01) = $01) Then
                moveentity(arg0\Field3, 0.0, 0.0, 0.5)
            EndIf
            rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), 0.0, $01)
        Else
            For local4 = $00 To $04 Step $01
                If (arg0\Field39[$00]\Field4[local4] <> Null) Then
                    If (local1 < entitydistancesquared(me\Field60, arg0\Field39[$00]\Field4[local4]\Field0)) Then
                        If (arg0\Field29 = $00) Then
                            If ((entityinview(arg0\Field3, camera) And entityvisible(me\Field60, arg0\Field3)) <> 0) Then
                                arg0\Field29 = $01
                                me\Field5 = min(-450.0, me\Field5)
                                me\Field23 = 0.7
                                me\Field30 = 0.7
                                me\Field28 = 150.0
                                playsound_strict(loadtempsound((("SFX\SCP\513_1\Bell" + (Str rand($00, $02))) + ".ogg")), $00, $01)
                            EndIf
                        EndIf
                        arg0\Field39[$00] = arg0\Field39[$00]\Field4[local4]
                        Exit
                    EndIf
                EndIf
            Next
            If (arg0\Field39[$00] = Null) Then
                arg0\Field11 = 0.0
            EndIf
        EndIf
        positionentity(arg0\Field0, entityx(arg0\Field3, $00), ((entityy(arg0\Field3, $00) - 0.2) + (sin((Float ((millisec Sar $03) Mod $168))) * 0.1)), entityz(arg0\Field3, $00), $00)
        Select arg0\Field10
            Case 1.0
                If (arg0\Field13 = $00) Then
                    animatenpc(arg0, 125.0, 194.0, (arg0\Field24 * 20.0), $01)
                Else
                    animatenpc(arg0, 195.0, 264.0, (arg0\Field24 * 20.0), $01)
                EndIf
                rotateentity(arg0\Field0, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
            Case 2.0
                If (arg0\Field13 = $00) Then
                    animatenpc(arg0, 2.0, 74.0, 0.2, $01)
                Else
                    animatenpc(arg0, 75.0, 124.0, 0.2, $01)
                EndIf
                rotateentity(arg0\Field0, 0.0, entityyaw(arg0\Field3, $00), 0.0, $00)
        End Select
        If (0.0 < arg0\Field11) Then
            If (16.0 > local1) Then
                arg0\Field11 = (arg0\Field11 - (fps\Field7[$00] * 4.0))
            EndIf
            arg0\Field11 = (arg0\Field11 - fps\Field7[$00])
        Else
            arg0\Field39[$00] = Null
            arg0\Field26 = 1.0
            arg0\Field11 = 0.0
        EndIf
    EndIf
    arg0\Field7 = 0.0
    resetentity(arg0\Field3)
    Return $00
End Function
