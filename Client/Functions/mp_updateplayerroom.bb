Function mp_updateplayerroom%(arg0.mp_player)
    Local local0.rooms
    Local local1%
    local0 = mp_rooms[arg0\Field22]
    If (local0 = Null) Then
        Return $00
    EndIf
    showroomsnocoll(local0)
    For local1 = $00 To $03 Step $01
        If (local0\Field19[local1] <> Null) Then
            showroomsnocoll(local0\Field19[local1])
        EndIf
    Next
    Return $00
End Function
