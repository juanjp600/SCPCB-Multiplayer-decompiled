Function updaterooms%()
    Local local0%
    Local local1%
    Local local2.rooms
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8#
    Local local9#
    Local local10#
    Local local11#
    Local local12%
    Local local13%
    Local local14.players
    Local local15%
    local7 = $01
    local8 = entityx(collider, $01)
    local9 = entityy(collider, $01)
    local10 = entityz(collider, $01)
    local11 = (local10 * 0.125)
    If (local11 < (Float (i_zone\Field0[$01] - (((selectedmap = "") And (networkserver\Field52\Field8 = "")) And (networkserver\Field52\Field8 = ""))))) Then
        playerzone = $02
    ElseIf (((local11 >= (Float (i_zone\Field0[$01] - ((selectedmap = "") And (networkserver\Field52\Field8 = ""))))) And (local11 < (Float (i_zone\Field0[$00] - ((selectedmap = "") And (networkserver\Field52\Field8 = "")))))) <> 0) Then
        playerzone = $01
    Else
        playerzone = $00
    EndIf
    templightvolume = 0.0
    local12 = $00
    local13 = $00
    If (playerroom <> Null) Then
        If (checkroomdeep(playerroom, $01) <> 0) Then
            local5 = (Abs (playerroom\Field4 - local8))
            If (4.0 > local5) Then
                local6 = (Abs (playerroom\Field6 - local10))
                If (4.0 > local6) Then
                    local12 = $01
                EndIf
            EndIf
            If (local12 = $00) Then
                For local0 = $00 To $03 Step $01
                    If (playerroom\Field34[local0] <> Null) Then
                        local5 = (Abs (playerroom\Field34[local0]\Field4 - local8))
                        If (4.0 > local5) Then
                            local6 = (Abs (playerroom\Field34[local0]\Field6 - local10))
                            If (4.0 > local6) Then
                                local12 = $01
                                playerroom = playerroom\Field34[local0]
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        Else
            local12 = $01
        EndIf
    EndIf
    renderroomlights()
    For local2 = Each rooms
        local5 = (Abs (local2\Field4 - local8))
        local6 = (Abs (local2\Field6 - local10))
        local2\Field9 = max(local5, local6)
        local2\Field73 = $00
        If (((16.0 > local5) And (16.0 > local6)) <> 0) Then
            For local0 = $00 To $0F Step $01
                If (local2\Field12[local0] <> $00) Then
                    local3 = entitydistancesquared(local2\Field13[local0], collider)
                    local4 = (local2\Field14[local0] * local2\Field14[local0])
                    If (local4 > local3) Then
                        local2\Field15[local0] = loopsound2(roomambience[local2\Field12[local0]], local2\Field15[local0], camera, local2\Field13[local0], local2\Field14[local0], 1.0)
                    EndIf
                EndIf
            Next
            If (((local12 = $00) And (playerroom <> local2)) <> 0) Then
                If (4.0 > local5) Then
                    If (4.0 > local6) Then
                        If (checkroomdeep(local2, $00) <> 0) Then
                            playerroom = local2
                        EndIf
                        local12 = $01
                    EndIf
                EndIf
            EndIf
        EndIf
        local7 = ((local2 = playerroom) = $00)
        If (local7 = $01) Then
            If (networkserver\Field15 = $01) Then
                For local14 = Each players
                    If (local14\Field0 <> networkserver\Field20) Then
                        If (local14\Field45 <> $00) Then
                            If (local2\Field65 = local14\Field45) Then
                                local7 = $00
                                Exit
                            EndIf
                            If (local7 <> 0) Then
                                If (isroomadjacent(room[local14\Field45], local2) <> 0) Then
                                    local7 = $00
                                    Exit
                                EndIf
                            EndIf
                            If (local7 <> 0) Then
                                For local0 = $00 To $03 Step $01
                                    If (isroomadjacent(room[local14\Field45]\Field34[local0], local2) <> 0) Then
                                        local7 = $00
                                        Exit
                                    EndIf
                                Next
                            EndIf
                            If (local7 = $00) Then
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        EndIf
        If (local7 <> 0) Then
            hideroomwithcollision(local2)
            hideroomlights(local2)
            hideroomdoors(local2, Null, $01)
            hideentity(local2\Field3)
        Else
            showroomwithcollision(local2)
            showroomdoors(local2)
        EndIf
    Next
    If (playerroom <> Null) Then
        mapfound((Int floor((entityx(playerroom\Field3, $00) * 0.125))), (Int floor((entityz(playerroom\Field3, $00) * 0.125)))) = $01
        playerroom\Field1 = $01
        updateroomlights(playerroom)
        For local0 = $00 To $03 Step $01
            If (playerroom\Field34[local0] <> Null) Then
                showroomwithcollision(playerroom\Field34[local0])
                showroomdoors(playerroom\Field34[local0])
                updateroomlights(playerroom\Field34[local0])
                If (playerroom\Field35[local0] <> Null) Then
                    If (0.0 = playerroom\Field35[local0]\Field7) Then
                        hideroomdoors(playerroom\Field34[local0], playerroom\Field35[local0], $01)
                        hideroomwithcollision(playerroom\Field34[local0])
                    EndIf
                EndIf
                If (networkserver\Field52\Field6 <> 0) Then
                    local15 = $01
                    For local1 = $00 To $03 Step $01
                        If (playerroom\Field34[local0]\Field34[local1] <> Null) Then
                            If (playerroom\Field34[local0]\Field34[local1] <> playerroom) Then
                                If (0.0 = playerroom\Field34[local0]\Field35[local1]\Field7) Then
                                    local15 = $00
                                EndIf
                                If (local15 = $00) Then
                                    showroomwithcollision(playerroom\Field34[local0]\Field34[local1])
                                    showroomdoors(playerroom\Field34[local0]\Field34[local1])
                                    updateroomlights(playerroom\Field34[local0]\Field34[local1])
                                EndIf
                            EndIf
                        EndIf
                    Next
                Else
                    For local1 = $00 To $03 Step $01
                        If (playerroom\Field34[local0]\Field34[local1] <> Null) Then
                            If (playerroom\Field34[local0]\Field34[local1] <> playerroom) Then
                                showentity(playerroom\Field34[local0]\Field34[local1]\Field3)
                                hideroomwithcollision(playerroom\Field34[local0]\Field34[local1])
                                updateroomlights(playerroom\Field34[local0]\Field34[local1])
                            EndIf
                        EndIf
                    Next
                EndIf
            EndIf
        Next
    EndIf
    templightvolume = max((templightvolume * 0.2222), 1.0)
    Return $00
End Function
