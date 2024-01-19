Function updaterooms%()
    Local local0#
    Local local1%
    Local local2%
    Local local3.rooms
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    Local local8%
    Local local9.players
    Local local10%
    local6 = $01
    If ((entityz(collider, $00) / 8.0) < (Float (i_zone\Field0[$01] - (((selectedmap = "") And (networkserver\Field44 = "")) And (networkserver\Field44 = ""))))) Then
        playerzone = $02
    ElseIf ((((entityz(collider, $00) / 8.0) >= (Float (i_zone\Field0[$01] - ((selectedmap = "") And (networkserver\Field44 = ""))))) And ((entityz(collider, $00) / 8.0) < (Float (i_zone\Field0[$00] - ((selectedmap = "") And (networkserver\Field44 = "")))))) <> 0) Then
        playerzone = $01
    Else
        playerzone = $00
    EndIf
    templightvolume = 0.0
    local7 = $00
    local8 = $00
    If (playerroom <> Null) Then
        If (checkroomdeep(playerroom, $01) <> 0) Then
            local4 = (Abs (playerroom\Field3 - entityx(collider, $01)))
            If (4.0 > local4) Then
                local5 = (Abs (playerroom\Field5 - entityz(collider, $01)))
                If (4.0 > local5) Then
                    local7 = $01
                EndIf
            EndIf
            If (local7 = $00) Then
                For local1 = $00 To $03 Step $01
                    If (playerroom\Field34[local1] <> Null) Then
                        local4 = (Abs (playerroom\Field34[local1]\Field3 - entityx(collider, $01)))
                        If (4.0 > local4) Then
                            local5 = (Abs (playerroom\Field34[local1]\Field5 - entityz(collider, $01)))
                            If (4.0 > local5) Then
                                local7 = $01
                                playerroom = playerroom\Field34[local1]
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        Else
            local7 = $01
        EndIf
    EndIf
    renderroomlights()
    For local3 = Each rooms
        local4 = (Abs (local3\Field3 - entityx(collider, $01)))
        local5 = (Abs (local3\Field5 - entityz(collider, $01)))
        local3\Field8 = max(local4, local5)
        local3\Field73 = $00
        If (((16.0 > local4) And (16.0 > local5)) <> 0) Then
            For local1 = $00 To $07 Step $01
                If (local3\Field12[local1] <> $00) Then
                    local0 = entitydistance(local3\Field13[local1], collider)
                    If (local0 < local3\Field14[local1]) Then
                        local3\Field15[local1] = loopsound2(roomambience[local3\Field12[local1]], local3\Field15[local1], camera, local3\Field13[local1], local3\Field14[local1], 1.0)
                    EndIf
                EndIf
            Next
            If (((local7 = $00) And (playerroom <> local3)) <> 0) Then
                If (4.0 > local4) Then
                    If (4.0 > local5) Then
                        If (checkroomdeep(local3, $00) <> 0) Then
                            playerroom = local3
                        EndIf
                        local7 = $01
                    EndIf
                EndIf
            EndIf
        EndIf
        local6 = ((local3 = playerroom) = $00)
        If (local6 = $01) Then
            If (networkserver\Field18 = $01) Then
                For local9 = Each players
                    If (local9\Field0 <> networkserver\Field28) Then
                        If (local9\Field47 <> $00) Then
                            If (local3\Field65 = local9\Field47) Then
                                local6 = $00
                                Exit
                            EndIf
                            If (local6 <> 0) Then
                                If (isroomadjacent(room[local9\Field47], local3) <> 0) Then
                                    local6 = $00
                                    Exit
                                EndIf
                            EndIf
                            If (local6 <> 0) Then
                                For local1 = $00 To $03 Step $01
                                    If (isroomadjacent(room[local9\Field47]\Field34[local1], local3) <> 0) Then
                                        local6 = $00
                                        Exit
                                    EndIf
                                Next
                            EndIf
                            If (local6 = $00) Then
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
        If (local6 <> 0) Then
            hideroomwithcollision(local3)
            hideroomlights(local3)
            hideroomdoors(local3, Null, $01)
            hideentity(local3\Field2)
        Else
            showroomwithcollision(local3)
            showroomdoors(local3)
        EndIf
    Next
    If (playerroom <> Null) Then
        mapfound((Int floor((entityx(playerroom\Field2, $00) / 8.0))), (Int floor((entityz(playerroom\Field2, $00) / 8.0)))) = $01
        playerroom\Field1 = $01
        updateroomlights(playerroom)
        For local1 = $00 To $03 Step $01
            If (playerroom\Field34[local1] <> Null) Then
                showroomwithcollision(playerroom\Field34[local1])
                showroomdoors(playerroom\Field34[local1])
                updateroomlights(playerroom\Field34[local1])
                If (playerroom\Field35[local1] <> Null) Then
                    If (0.0 = playerroom\Field35[local1]\Field7) Then
                        hideroomdoors(playerroom\Field34[local1], playerroom\Field35[local1], $01)
                        hideroomwithcollision(playerroom\Field34[local1])
                    EndIf
                EndIf
                If (networkserver\Field47 <> 0) Then
                    local10 = $01
                    For local2 = $00 To $03 Step $01
                        If (playerroom\Field34[local1]\Field34[local2] <> Null) Then
                            If (playerroom\Field34[local1]\Field34[local2] <> playerroom) Then
                                If (0.0 = playerroom\Field34[local1]\Field35[local2]\Field7) Then
                                    local10 = $00
                                EndIf
                                If (local10 = $00) Then
                                    showroomwithcollision(playerroom\Field34[local1]\Field34[local2])
                                    showroomdoors(playerroom\Field34[local1]\Field34[local2])
                                    updateroomlights(playerroom\Field34[local1]\Field34[local2])
                                EndIf
                            EndIf
                        EndIf
                    Next
                Else
                    For local2 = $00 To $03 Step $01
                        If (playerroom\Field34[local1]\Field34[local2] <> Null) Then
                            If (playerroom\Field34[local1]\Field34[local2] <> playerroom) Then
                                showentity(playerroom\Field34[local1]\Field34[local2]\Field2)
                                hideroomwithcollision(playerroom\Field34[local1]\Field34[local2])
                                updateroomlights(playerroom\Field34[local1]\Field34[local2])
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        Next
    EndIf
    templightvolume = max((templightvolume / 4.5), 1.0)
    Return $00
End Function
