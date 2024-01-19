Function updatenetworkitems%()
    Local local0.items
    Local local1.items
    Local local2%
    Local local3#
    Local local4%
    Local local5#
    Local local6%
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12.players
    Local local13%
    Local local14#
    Local local15%
    Local local16%
    local3 = (hidedistance * 0.5)
    closestitem = Null
    If (networkserver\Field18 <> 0) Then
        For local0 = Each items
            hideentity(local0\Field1)
            local0\Field31 = $00
            If (local0\Field15 = $00) Then
                For local12 = Each players
                    If (local3 > entitydistance(local12\Field13, local0\Field1)) Then
                        local0\Field31 = $01
                        Exit
                    EndIf
                Next
                If ((Float millisecs()) > local0\Field12) Then
                    local0\Field11 = entitydistance(camera, local0\Field1)
                    local0\Field12 = (Float (millisecs() + $2BC))
                EndIf
                If (((local3 > local0\Field11) Or local0\Field31) <> 0) Then
                    showentity(local0\Field1)
                    If (1.2 > local0\Field11) Then
                        If (closestitem = Null) Then
                            If (entityinview(local0\Field2, camera) <> 0) Then
                                If (entityvisible(local0\Field1, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        ElseIf (((closestitem = local0) Or (entitydistance(camera, closestitem\Field1) > local0\Field11)) <> 0) Then
                            If (entityinview(local0\Field2, camera) <> 0) Then
                                If (entityvisible(local0\Field1, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field3\Field0 = $92) Then
                        If (((multiplayer_isascp(myplayer\Field51) = $00) And (player_isdead() = $00)) <> 0) Then
                            If (4.0 > entitydistance(camera, local0\Field1)) Then
                                If (entityvisible(local0\Field1, myhitbox) <> 0) Then
                                    sanity = (sanity - fpsfactor)
                                    restoresanity = $00
                                    local13 = createpivot($00)
                                    positionentity(local13, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local13, local0\Field1, 0.0)
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local13, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                                    user_camera_pitch = curvevalue(entitypitch(local13, $00), user_camera_pitch, min(max((15000.0 / (- sanity)), 20.0), 200.0))
                                    If (0.5 < entitydistance(camera, local0\Field1)) Then
                                        local14 = wrapangle((entityyaw(local13, $00) - entityyaw(collider, $00)))
                                        If (40.0 > local14) Then
                                            forcemove = ((40.0 - local14) * 0.008)
                                        ElseIf (310.0 < local14) Then
                                            forcemove = ((40.0 - (Abs (360.0 - local14))) * 0.008)
                                        EndIf
                                    EndIf
                                    freeentity(local13)
                                    If (-1500.0 > sanity) Then
                                        If (0.0 = vomittimer) Then
                                            vomittimer = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field30 = $00) Then
                        If (((entityy(local0\Field1, $00) = local0\Field28) And shouldentitiesfall) <> 0) Then
                            local0\Field30 = $01
                            local0\Field4 = 0.0
                        Else
                            local0\Field28 = -21849190.0
                            If (shouldentitiesfall <> 0) Then
                                local2 = linepick(entityx(local0\Field1, $00), entityy(local0\Field1, $00), entityz(local0\Field1, $00), 0.0, -10.0, 0.0, 0.0)
                                If (local2 <> 0) Then
                                    local0\Field28 = entityy(local0\Field1, $00)
                                    local0\Field4 = (local0\Field4 - (0.0004 * fpsfactor))
                                    translateentity(local0\Field1, 0.0, (local0\Field4 * fpsfactor), 0.0, $00)
                                    detectitemmoving = (detectitemmoving + $01)
                                Else
                                    local0\Field4 = 0.0
                                EndIf
                            Else
                                local0\Field4 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    If (-35.0 > entityy(local0\Field1, $00)) Then
                        If (local0\Field30 = $00) Then
                            removeitem(local0, $01)
                            Return $00
                        Else
                            positionentity(local0\Field1, entityy(local0\Field1, $00), local0\Field28, entityz(local0\Field1, $00), $01)
                            resetentity(local0\Field1)
                        EndIf
                    EndIf
                EndIf
            Else
                positionentity(local0\Field1, entityx(player[local0\Field22]\Field13, $00), entityy(player[local0\Field22]\Field13, $00), entityz(player[local0\Field22]\Field13, $00), $01)
                resetentity(local0\Field1)
                local0\Field30 = $00
                local0\Field28 = -41189.0
                local0\Field4 = 0.0
                If (local0\Field22 = networkserver\Field28) Then
                    local6 = $00
                    For local7 = $00 To $09 Step $01
                        If (inventory(local7) = local0) Then
                            local6 = $01
                            Exit
                        EndIf
                    Next
                    If (local6 = $00) Then
                        For local7 = $00 To $09 Step $01
                            If (inventory(local7) <> Null) Then
                                For local15 = $00 To (inventory(local7)\Field19 - $01) Step $01
                                    If (inventory(local7)\Field17[local15] = local0) Then
                                        local6 = $01
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Next
                        If (local6 = $00) Then
                            For local7 = $00 To $09 Step $01
                                If (inventory(local7) = Null) Then
                                    inventory(local7) = local0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    For local7 = $00 To $09 Step $01
                        If (inventory(local7) <> Null) Then
                            If (inventory(local7) = local0) Then
                                inventory(local7) = Null
                                Exit
                            EndIf
                            For local15 = $00 To (inventory(local7)\Field19 - $01) Step $01
                                If (inventory(local7)\Field17[local15] = local0) Then
                                    inventory(local7)\Field17[local15] = Null
                                    Exit
                                EndIf
                            Next
                        EndIf
                    Next
                EndIf
            EndIf
            rotateentity(local0\Field1, 0.0, (Float itemsrotaterand), 0.0, $00)
            If (local0\Field22 <> $00) Then
                If (local0\Field22 <> networkserver\Field28) Then
                    If (player[local0\Field22]\Field78 = $01) Then
                        If (player[local0\Field22]\Field68 = local0\Field18) Then
                            local4 = getplayerhand(local0\Field22)
                            If (local4 <> $00) Then
                                If (local3 > entitydistance(camera, local4)) Then
                                    showentity(local0\Field1)
                                    positionentity(local0\Field1, entityx(local4, $01), entityy(local4, $01), entityz(local4, $01), $01)
                                    rotateentity(local0\Field1, (entitypitch(local4, $01) - 45.0), (entityyaw(local4, $01) - 70.0), (entityroll(local4, $01) + 20.0), $01)
                                    resetentity(local0\Field1)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Next
        If (detectitemmoving <> 0) Then
            local16 = $00
            For local0 = Each items
                If (local0\Field31 <> 0) Then
                    For local1 = Each items
                        If (local1\Field31 <> 0) Then
                            If (local0 <> local1) Then
                                If (local1\Field15 = $00) Then
                                    local9 = (entityx(local1\Field1, $01) - entityx(local0\Field1, $01))
                                    local10 = (entityy(local1\Field1, $01) - entityy(local0\Field1, $01))
                                    local11 = (entityz(local1\Field1, $01) - entityz(local0\Field1, $01))
                                    local8 = ((local9 * local9) + (local11 * local11))
                                    If (0.07 > local8) Then
                                        If (0.25 > (Abs local10)) Then
                                            local9 = ((0.07 - local8) * local9)
                                            local11 = ((0.07 - local8) * local11)
                                            While (0.001 > ((Abs local9) + (Abs local11)))
                                                local9 = (rnd(-0.002, 0.002) + local9)
                                                local11 = (rnd(-0.002, 0.002) + local11)
                                            Wend
                                            local0\Field30 = $00
                                            local0\Field28 = -41189.0
                                            local1\Field30 = $00
                                            local1\Field28 = -41189.0
                                            translateentity(local1\Field1, local9, 0.0, local11, $00)
                                            translateentity(local0\Field1, (- local9), 0.0, (- local11), $00)
                                            local16 = $01
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            Next
            If (local16 = $00) Then
                detectitemmoving = $00
            EndIf
        EndIf
    Else
        For local0 = Each items
            hideentity(local0\Field1)
            local0\Field31 = $00
            If (local0\Field15 = $00) Then
                If ((Float millisecs()) > local0\Field12) Then
                    local0\Field11 = entitydistance(camera, local0\Field1)
                    local0\Field12 = (Float (millisecs() + $2BC))
                EndIf
                If (((local3 > local0\Field11) Or local0\Field31) <> 0) Then
                    showentity(local0\Field1)
                    If (1.2 > local0\Field11) Then
                        If (closestitem = Null) Then
                            If (entityinview(local0\Field2, camera) <> 0) Then
                                If (entityvisible(local0\Field1, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        ElseIf (((closestitem = local0) Or (entitydistance(camera, closestitem\Field1) > local0\Field11)) <> 0) Then
                            If (entityinview(local0\Field2, camera) <> 0) Then
                                If (entityvisible(local0\Field1, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field3\Field0 = $92) Then
                        If (((multiplayer_isascp(myplayer\Field51) = $00) And (player_isdead() = $00)) <> 0) Then
                            If (4.0 > entitydistance(camera, local0\Field1)) Then
                                If (entityvisible(local0\Field1, myhitbox) <> 0) Then
                                    sanity = (sanity - fpsfactor)
                                    restoresanity = $00
                                    local13 = createpivot($00)
                                    positionentity(local13, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local13, local0\Field1, 0.0)
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local13, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                                    user_camera_pitch = curvevalue(entitypitch(local13, $00), user_camera_pitch, min(max((15000.0 / (- sanity)), 20.0), 200.0))
                                    If (0.5 < entitydistance(camera, local0\Field1)) Then
                                        local14 = wrapangle((entityyaw(local13, $00) - entityyaw(collider, $00)))
                                        If (40.0 > local14) Then
                                            forcemove = ((40.0 - local14) * 0.008)
                                        ElseIf (310.0 < local14) Then
                                            forcemove = ((40.0 - (Abs (360.0 - local14))) * 0.008)
                                        EndIf
                                    EndIf
                                    freeentity(local13)
                                    If (-1500.0 > sanity) Then
                                        If (0.0 = vomittimer) Then
                                            vomittimer = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field30 = $00) Then
                        If (((entityy(local0\Field1, $00) = local0\Field28) And shouldentitiesfall) <> 0) Then
                            local0\Field30 = $01
                            local0\Field4 = 0.0
                        Else
                            local0\Field28 = -21849190.0
                            If (shouldentitiesfall <> 0) Then
                                local2 = linepick(entityx(local0\Field1, $00), entityy(local0\Field1, $00), entityz(local0\Field1, $00), 0.0, -10.0, 0.0, 0.0)
                                If (local2 <> 0) Then
                                    local0\Field28 = entityy(local0\Field1, $00)
                                    local0\Field4 = (local0\Field4 - (0.0004 * fpsfactor))
                                    translateentity(local0\Field1, 0.0, (local0\Field4 * fpsfactor), 0.0, $00)
                                    detectitemmoving = (detectitemmoving + $01)
                                Else
                                    local0\Field4 = 0.0
                                EndIf
                            Else
                                local0\Field4 = 0.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Else
                positionentity(local0\Field1, entityx(player[local0\Field22]\Field13, $00), entityy(player[local0\Field22]\Field13, $00), entityz(player[local0\Field22]\Field13, $00), $01)
                resetentity(local0\Field1)
                local0\Field30 = $00
                local0\Field28 = -41189.0
                local0\Field4 = 0.0
                If (local0\Field22 = networkserver\Field28) Then
                    local6 = $00
                    For local7 = $00 To $09 Step $01
                        If (inventory(local7) = local0) Then
                            local6 = $01
                            Exit
                        EndIf
                    Next
                    If (local6 = $00) Then
                        For local7 = $00 To $09 Step $01
                            If (inventory(local7) <> Null) Then
                                For local15 = $00 To (inventory(local7)\Field19 - $01) Step $01
                                    If (inventory(local7)\Field17[local15] = local0) Then
                                        local6 = $01
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Next
                        If (local6 = $00) Then
                            For local7 = $00 To $09 Step $01
                                If (inventory(local7) = Null) Then
                                    inventory(local7) = local0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    For local7 = $00 To $09 Step $01
                        If (inventory(local7) <> Null) Then
                            If (inventory(local7) = local0) Then
                                inventory(local7) = Null
                                Exit
                            EndIf
                            For local15 = $00 To (inventory(local7)\Field19 - $01) Step $01
                                If (inventory(local7)\Field17[local15] = local0) Then
                                    inventory(local7)\Field17[local15] = Null
                                    Exit
                                EndIf
                            Next
                        EndIf
                    Next
                EndIf
            EndIf
            local5 = distance(entityx(local0\Field1, $01), entityz(local0\Field1, $01), local0\Field24, local0\Field26)
            If (0.3 < distance(entityy(local0\Field1, $00), 0.0, local0\Field25, 0.0)) Then
                local0\Field32 = (local0\Field32 - fpsfactor)
            Else
                local0\Field32 = 70.0
            EndIf
            If (((4.0 < local5) Or (1.0 > local0\Field32)) <> 0) Then
                positionentity(local0\Field1, local0\Field24, local0\Field25, local0\Field26, $01)
                resetentity(local0\Field1)
                local0\Field30 = $00
                detectitemmoving = (detectitemmoving + $01)
            ElseIf (local0\Field30 <> 0) Then
                positionentity(local0\Field1, curvevalue(local0\Field24, entityx(local0\Field1, $01), 5.0), entityy(local0\Field1, $00), curvevalue(local0\Field26, entityz(local0\Field1, $01), 5.0), $01)
                resetentity(local0\Field1)
            EndIf
            rotateentity(local0\Field1, 0.0, (Float itemsrotaterand), 0.0, $00)
            If (local0\Field22 <> $00) Then
                If (local0\Field22 <> networkserver\Field28) Then
                    If (player[local0\Field22]\Field78 = $01) Then
                        If (player[local0\Field22]\Field68 = local0\Field18) Then
                            local4 = getplayerhand(local0\Field22)
                            If (local4 <> $00) Then
                                If (local3 > entitydistance(camera, local4)) Then
                                    showentity(local0\Field1)
                                    positionentity(local0\Field1, entityx(local4, $01), entityy(local4, $01), entityz(local4, $01), $01)
                                    rotateentity(local0\Field1, (entitypitch(local4, $01) - 45.0), (entityyaw(local4, $01) - 70.0), (entityroll(local4, $01) + 20.0), $01)
                                    resetentity(local0\Field1)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    If (closestitem <> Null) Then
        If (caninteract() <> 0) Then
            If (((mouseinteract And mousehit1) Or ((mouseinteract = $00) And ismouseup())) <> 0) Then
                pickitem(closestitem)
                blockguns = $01
            EndIf
        EndIf
    EndIf
    Return $00
End Function
