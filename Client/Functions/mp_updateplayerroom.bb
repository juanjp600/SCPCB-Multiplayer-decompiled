Function mp_updateplayerroom%(arg0.mp_player)
    Local local0.rooms
    Local local1#
    Local local2%
    local0 = mp_rooms[arg0\Field22]
    If (local0 = Null) Then
        Return $00
    EndIf
    local1 = entityy(arg0\Field18, $00)
    showroomsnocoll(local0)
    For local2 = $00 To $03 Step $01
        If (local0\Field19[local2] <> Null) Then
            If (local0\Field20[local2] <> Null) Then
                If (local0\Field19[local2] <> local0) Then
                    If (((((0.0 = local0\Field20[local2]\Field8) Lor (entityinview(local0\Field20[local2]\Field2, arg0\Field19) = $00)) Lor (8.0 < local1)) Lor (-8.0 > local1)) = $00) Then
                        showroomsnocoll(local0\Field19[local2])
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
