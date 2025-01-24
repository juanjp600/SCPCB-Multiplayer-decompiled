Function updaterooms%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.rooms
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9#
    Local local10%
    Local local11#
    Local local12#
    Local local13%
    catcherrors("UpdateRooms()")
    local4 = entityx(me\Field60, $01)
    local5 = entityy(me\Field60, $01)
    local6 = entityz(me\Field60, $01)
    local7 = (i_zone\Field0[$00] - (selectedcustommap = Null))
    local8 = (i_zone\Field0[$01] - (selectedcustommap = Null))
    local9 = (local6 / 8.0)
    me\Field59 = $00
    If ((Float local8) > local9) Then
        me\Field59 = $02
    ElseIf ((((Float local8) <= local9) And ((Float local7) > local9)) <> 0) Then
        me\Field59 = $01
    EndIf
    local10 = $00
    If (1.5 > (Abs (local5 - entityy(playerroom\Field2, $00)))) Then
        If (((4.0 > (Abs (playerroom\Field3 - local4))) And (4.0 > (Abs (playerroom\Field5 - local6)))) <> 0) Then
            local10 = $01
        EndIf
        If (local10 = $00) Then
            For local1 = $00 To $03 Step $01
                If (playerroom\Field19[local1] <> Null) Then
                    If ((((4.0 > (Abs (playerroom\Field19[local1]\Field3 - local4))) And (4.0 > (Abs (playerroom\Field19[local1]\Field5 - local6)))) And (4.0 > (Abs (playerroom\Field19[local1]\Field4 - local5)))) <> 0) Then
                        local10 = $01
                        playerroom = playerroom\Field19[local1]
                        Exit
                    EndIf
                EndIf
            Next
        EndIf
    EndIf
    For local3 = Each rooms
        local11 = (Abs (local3\Field3 - local4))
        local12 = (Abs (local3\Field5 - local6))
        local3\Field8 = max(local11, local12)
        If (((4.0 > local11) And (4.0 > local12)) <> 0) Then
            If (((local10 = $00) And (playerroom <> local3)) <> 0) Then
                If (1.5 > (Abs (local5 - entityy(local3\Field2, $00)))) Then
                    playerroom = local3
                EndIf
                local10 = $01
            EndIf
        EndIf
        local13 = $01
        If (local3 = playerroom) Then
            local13 = $00
        EndIf
        If (isroomadjacent(playerroom, local3) <> 0) Then
            local13 = $00
        EndIf
        For local1 = $00 To $03 Step $01
            If (isroomadjacent(playerroom\Field19[local1], local3) <> 0) Then
                local13 = $00
                Exit
            EndIf
        Next
        If (local13 <> 0) Then
            hideroomsnocoll(local3)
        Else
            showroomsnocoll(local3)
        EndIf
    Next
    currmapgrid\Field2[(Int (floor((entityx(playerroom\Field2, $00) / 8.0)) + (floor((entityz(playerroom\Field2, $00) / 8.0)) * 21.0)))] = $01
    playerroom\Field1 = $01
    showroomscoll(playerroom)
    For local1 = $00 To $03 Step $01
        If (playerroom\Field19[local1] <> Null) Then
            If (playerroom\Field20[local1] <> Null) Then
                If (playerroom\Field19[local1] <> playerroom) Then
                    If (((((0.0 = playerroom\Field20[local1]\Field8) Lor (entityinview(playerroom\Field20[local1]\Field2, camera) = $00)) Lor (8.0 < local5)) Lor (-8.0 > local5)) <> 0) Then
                        hideroomscoll(playerroom\Field19[local1])
                    Else
                        showroomscoll(playerroom\Field19[local1])
                    EndIf
                EndIf
            EndIf
            For local2 = $00 To $03 Step $01
                If (playerroom\Field19[local1]\Field19[local2] <> Null) Then
                    If (playerroom\Field19[local1]\Field19[local2] <> playerroom) Then
                        hideroomscoll(playerroom\Field19[local1]\Field19[local2])
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mp_updateplayerrooms()
    catcherrors("Uncaught: UpdateRooms()")
    Return $00
End Function
