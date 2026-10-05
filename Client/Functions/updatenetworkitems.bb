Function updatenetworkitems%()
    Local local0.items
    Local local1.items
    Local local2%
    Local local3#
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15.players
    Local local16%
    Local local17#
    Local local18%
    Local local19%
    local3 = (hidedistance * 0.5)
    local5 = entityx(collider, $01)
    local6 = entityy(collider, $01)
    local7 = entityz(collider, $01)
    closestitem = Null
    If (networkserver\Field15 <> 0) Then
        For local0 = Each items
            hideentity(local0\Field2)
            local0\Field32 = $00
            If (local0\Field16 = $00) Then
                For local15 = Each players
                    If (local3 > entitydistance(local15\Field13, local0\Field2)) Then
                        local0\Field32 = $01
                        Exit
                    EndIf
                Next
                If ((Float millisecs()) > local0\Field12) Then
                    local0\Field11 = entitydistance(collider, local0\Field2)
                    local0\Field12 = (Float (millisecs() + $64))
                EndIf
                If (((local3 > local0\Field11) Or local0\Field32) <> 0) Then
                    showentity(local0\Field2)
                    If (1.2 > local0\Field11) Then
                        If (closestitem = Null) Then
                            If (entityinview(local0\Field3, camera) <> 0) Then
                                If (entityvisible(local0\Field2, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        ElseIf (((closestitem = local0) Or (entitydistance(collider, closestitem\Field2) > local0\Field11)) <> 0) Then
                            If (entityinview(local0\Field3, camera) <> 0) Then
                                If (entityvisible(local0\Field2, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field1\Field0 = $92) Then
                        If (((multiplayer_isascp(myplayer\Field49) = $00) And (player_isdead() = $00)) <> 0) Then
                            If (4.0 > entitydistance(camera, local0\Field2)) Then
                                If (entityvisible(local0\Field2, myhitbox) <> 0) Then
                                    sanity = (sanity - fpsfactor)
                                    restoresanity = $00
                                    local16 = createpivot($00)
                                    positionentity(local16, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local16, local0\Field2, 0.0)
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local16, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                                    user_camera_pitch = curvevalue(entitypitch(local16, $00), user_camera_pitch, min(max((15000.0 / (- sanity)), 20.0), 200.0))
                                    If (0.5 < entitydistance(camera, local0\Field2)) Then
                                        local17 = wrapangle((entityyaw(local16, $00) - entityyaw(collider, $00)))
                                        If (40.0 > local17) Then
                                            forcemove = ((40.0 - local17) * 0.008)
                                        ElseIf (310.0 < local17) Then
                                            forcemove = ((40.0 - (Abs (360.0 - local17))) * 0.008)
                                        EndIf
                                    EndIf
                                    freeentity(local16)
                                    If (-1500.0 > sanity) Then
                                        If (0.0 = vomittimer) Then
                                            vomittimer = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field31 = $00) Then
                        If (((entityy(local0\Field2, $00) = local0\Field29) And shouldentitiesfall) <> 0) Then
                            local0\Field31 = $01
                            local0\Field4 = 0.0
                        Else
                            local0\Field29 = -21849190.0
                            If (shouldentitiesfall <> 0) Then
                                local2 = linepick(entityx(local0\Field2, $00), entityy(local0\Field2, $00), entityz(local0\Field2, $00), 0.0, -10.0, 0.0, 0.0)
                                If (local2 <> 0) Then
                                    local0\Field29 = entityy(local0\Field2, $00)
                                    local0\Field4 = (local0\Field4 - (0.0004 * fpsfactor))
                                    translateentity(local0\Field2, 0.0, (local0\Field4 * fpsfactor), 0.0, $00)
                                    detectitemmoving = (detectitemmoving + $01)
                                Else
                                    local0\Field4 = 0.0
                                EndIf
                            Else
                                local0\Field4 = 0.0
                            EndIf
                        EndIf
                    EndIf
                    If (-35.0 > entityy(local0\Field2, $00)) Then
                        If (local0\Field31 = $00) Then
                            removeitem(local0, $01)
                            Return $00
                        EndIf
                    EndIf
                EndIf
            Else
                If (((local0 <> Null) And (player[local0\Field22] <> Null)) <> 0) Then
                    If (((local0\Field2 <> $00) And (player[local0\Field22]\Field13 <> $00)) <> 0) Then
                        positionentity(local0\Field2, entityx(player[local0\Field22]\Field13, $00), entityy(player[local0\Field22]\Field13, $00), entityz(player[local0\Field22]\Field13, $00), $01)
                        resetentity(local0\Field2)
                    EndIf
                EndIf
                local0\Field31 = $00
                local0\Field29 = -41189.0
                local0\Field4 = 0.0
                If (local0\Field22 = networkserver\Field20) Then
                    local9 = $00
                    For local10 = $00 To $09 Step $01
                        If (inventory(local10) = local0) Then
                            local9 = $01
                            Exit
                        EndIf
                    Next
                    If (local9 = $00) Then
                        For local10 = $00 To $09 Step $01
                            If (inventory(local10) <> Null) Then
                                For local18 = $00 To (inventory(local10)\Field20 - $01) Step $01
                                    If (inventory(local10)\Field18[local18] = local0) Then
                                        local9 = $01
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Next
                        If (local9 = $00) Then
                            For local10 = $00 To $09 Step $01
                                If (inventory(local10) = Null) Then
                                    inventory(local10) = local0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    For local10 = $00 To $09 Step $01
                        If (inventory(local10) <> Null) Then
                            If (inventory(local10) = local0) Then
                                inventory(local10) = Null
                                Exit
                            EndIf
                            For local18 = $00 To (inventory(local10)\Field20 - $01) Step $01
                                If (inventory(local10)\Field18[local18] = local0) Then
                                    inventory(local10)\Field18[local18] = Null
                                    Exit
                                EndIf
                            Next
                        EndIf
                    Next
                EndIf
            EndIf
            rotateentity(local0\Field2, 0.0, (Float itemsrotaterand), 0.0, $00)
            If (local0\Field22 <> $00) Then
                If (local0\Field22 <> networkserver\Field20) Then
                    If (player[local0\Field22]\Field76 = $01) Then
                        If (player[local0\Field22]\Field66 = local0\Field19) Then
                            local4 = getplayerhand(local0\Field22)
                            If (local4 <> $00) Then
                                If (local3 > entitydistance(camera, local4)) Then
                                    showentity(local0\Field2)
                                    positionentity(local0\Field2, entityx(local4, $01), entityy(local4, $01), entityz(local4, $01), $01)
                                    rotateentity(local0\Field2, (entitypitch(local4, $01) - 45.0), (entityyaw(local4, $01) - 70.0), (entityroll(local4, $01) + 20.0), $01)
                                    resetentity(local0\Field2)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Next
        If (detectitemmoving <> 0) Then
            local19 = $00
            For local0 = Each items
                If (local0\Field32 <> 0) Then
                    For local1 = Each items
                        If (local1\Field32 <> 0) Then
                            If (local0 <> local1) Then
                                If (local1\Field16 = $00) Then
                                    local12 = (entityx(local1\Field2, $01) - entityx(local0\Field2, $01))
                                    local13 = (entityy(local1\Field2, $01) - entityy(local0\Field2, $01))
                                    local14 = (entityz(local1\Field2, $01) - entityz(local0\Field2, $01))
                                    local11 = ((local12 * local12) + (local14 * local14))
                                    If (0.07 > local11) Then
                                        If (0.25 > (Abs local13)) Then
                                            local12 = ((0.07 - local11) * local12)
                                            local14 = ((0.07 - local11) * local14)
                                            While (0.001 > ((Abs local12) + (Abs local14)))
                                                local12 = (rnd(-0.002, 0.002) + local12)
                                                local14 = (rnd(-0.002, 0.002) + local14)
                                            Wend
                                            local0\Field31 = $00
                                            local0\Field29 = -41189.0
                                            local1\Field31 = $00
                                            local1\Field29 = -41189.0
                                            translateentity(local1\Field2, local12, 0.0, local14, $00)
                                            translateentity(local0\Field2, (- local12), 0.0, (- local14), $00)
                                            local19 = $01
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                EndIf
            Next
            If (local19 = $00) Then
                detectitemmoving = $00
            EndIf
        EndIf
    Else
        For local0 = Each items
            hideentity(local0\Field2)
            local0\Field32 = $00
            If (local0\Field16 = $00) Then
                If ((Float millisecs()) > local0\Field12) Then
                    local0\Field11 = entitydistance(camera, local0\Field2)
                    local0\Field12 = (Float (millisecs() + $2BC))
                EndIf
                If (((local3 > local0\Field11) Or local0\Field32) <> 0) Then
                    showentity(local0\Field2)
                    If (1.2 > local0\Field11) Then
                        If (closestitem = Null) Then
                            If (entityinview(local0\Field3, camera) <> 0) Then
                                If (entityvisible(local0\Field2, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        ElseIf (((closestitem = local0) Or (entitydistance(collider, closestitem\Field2) > local0\Field11)) <> 0) Then
                            If (entityinview(local0\Field3, camera) <> 0) Then
                                If (entityvisible(local0\Field2, camera) <> 0) Then
                                    closestitem = local0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field1\Field0 = $92) Then
                        If (((multiplayer_isascp(myplayer\Field49) = $00) And (player_isdead() = $00)) <> 0) Then
                            If (4.0 > entitydistance(camera, local0\Field2)) Then
                                If (entityvisible(local0\Field2, myhitbox) <> 0) Then
                                    sanity = (sanity - fpsfactor)
                                    restoresanity = $00
                                    local16 = createpivot($00)
                                    positionentity(local16, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local16, local0\Field2, 0.0)
                                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local16, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 20.0), 200.0)), 0.0, $00)
                                    user_camera_pitch = curvevalue(entitypitch(local16, $00), user_camera_pitch, min(max((15000.0 / (- sanity)), 20.0), 200.0))
                                    If (0.5 < entitydistance(camera, local0\Field2)) Then
                                        local17 = wrapangle((entityyaw(local16, $00) - entityyaw(collider, $00)))
                                        If (40.0 > local17) Then
                                            forcemove = ((40.0 - local17) * 0.008)
                                        ElseIf (310.0 < local17) Then
                                            forcemove = ((40.0 - (Abs (360.0 - local17))) * 0.008)
                                        EndIf
                                    EndIf
                                    freeentity(local16)
                                    If (-1500.0 > sanity) Then
                                        If (0.0 = vomittimer) Then
                                            vomittimer = 1.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If (local0\Field31 = $00) Then
                        If (((entityy(local0\Field2, $00) = local0\Field29) And shouldentitiesfall) <> 0) Then
                            local0\Field31 = $01
                            local0\Field4 = 0.0
                        Else
                            local0\Field29 = -21849190.0
                            If (shouldentitiesfall <> 0) Then
                                local2 = linepick(entityx(local0\Field2, $00), entityy(local0\Field2, $00), entityz(local0\Field2, $00), 0.0, -10.0, 0.0, 0.0)
                                If (local2 <> 0) Then
                                    local0\Field29 = entityy(local0\Field2, $00)
                                    local0\Field4 = (local0\Field4 - (0.0004 * fpsfactor))
                                    translateentity(local0\Field2, 0.0, (local0\Field4 * fpsfactor), 0.0, $00)
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
                positionentity(local0\Field2, entityx(player[local0\Field22]\Field13, $00), entityy(player[local0\Field22]\Field13, $00), entityz(player[local0\Field22]\Field13, $00), $01)
                resetentity(local0\Field2)
                local0\Field31 = $00
                local0\Field29 = -41189.0
                local0\Field4 = 0.0
                If (local0\Field22 = networkserver\Field20) Then
                    local9 = $00
                    For local10 = $00 To $09 Step $01
                        If (inventory(local10) = local0) Then
                            local9 = $01
                            Exit
                        EndIf
                    Next
                    If (local9 = $00) Then
                        For local10 = $00 To $09 Step $01
                            If (inventory(local10) <> Null) Then
                                For local18 = $00 To (inventory(local10)\Field20 - $01) Step $01
                                    If (inventory(local10)\Field18[local18] = local0) Then
                                        local9 = $01
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Next
                        If (local9 = $00) Then
                            For local10 = $00 To $09 Step $01
                                If (inventory(local10) = Null) Then
                                    inventory(local10) = local0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    For local10 = $00 To $09 Step $01
                        If (inventory(local10) <> Null) Then
                            If (inventory(local10) = local0) Then
                                inventory(local10) = Null
                                Exit
                            EndIf
                            For local18 = $00 To (inventory(local10)\Field20 - $01) Step $01
                                If (inventory(local10)\Field18[local18] = local0) Then
                                    inventory(local10)\Field18[local18] = Null
                                    Exit
                                EndIf
                            Next
                        EndIf
                    Next
                EndIf
            EndIf
            local8 = distance(entityx(local0\Field2, $01), entityz(local0\Field2, $01), local0\Field25, local0\Field27)
            If (0.3 < distance(entityy(local0\Field2, $00), 0.0, local0\Field26, 0.0)) Then
                local0\Field33 = (local0\Field33 - fpsfactor)
            Else
                local0\Field33 = 70.0
            EndIf
            If (((4.0 < local8) Or (1.0 > local0\Field33)) <> 0) Then
                positionentity(local0\Field2, local0\Field25, local0\Field26, local0\Field27, $01)
                resetentity(local0\Field2)
                local0\Field31 = $00
                detectitemmoving = (detectitemmoving + $01)
            ElseIf (local0\Field31 <> 0) Then
                positionentity(local0\Field2, curvevalue(local0\Field25, entityx(local0\Field2, $01), 5.0), entityy(local0\Field2, $00), curvevalue(local0\Field27, entityz(local0\Field2, $01), 5.0), $01)
                resetentity(local0\Field2)
            EndIf
            rotateentity(local0\Field2, 0.0, (Float itemsrotaterand), 0.0, $00)
            If (local0\Field22 <> $00) Then
                If (local0\Field22 <> networkserver\Field20) Then
                    If (player[local0\Field22]\Field76 = $01) Then
                        If (player[local0\Field22]\Field66 = local0\Field19) Then
                            local4 = getplayerhand(local0\Field22)
                            If (local4 <> $00) Then
                                If (local3 > entitydistance(camera, local4)) Then
                                    showentity(local0\Field2)
                                    positionentity(local0\Field2, entityx(local4, $01), entityy(local4, $01), entityz(local4, $01), $01)
                                    rotateentity(local0\Field2, (entitypitch(local4, $01) - 45.0), (entityyaw(local4, $01) - 70.0), (entityroll(local4, $01) + 20.0), $01)
                                    resetentity(local0\Field2)
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
