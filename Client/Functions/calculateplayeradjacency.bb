Function calculateplayeradjacency#(arg0.mp_player, arg1.mp_player)
    Local local0.rooms
    Local local1.rooms
    Local local2%
    Local local3%
    local0 = mp_rooms[arg0\Field22]
    local1 = mp_rooms[arg1\Field22]
    If ((((local0 = Null) Lor (local1 = Null)) Lor (local0 = local1)) <> 0) Then
        Return 1.0
    EndIf
    For local2 = $00 To $03 Step $01
        If (local0\Field19[local2] <> Null) Then
            If (local0\Field19[local2] = local1) Then
                If (local0\Field20[local2] <> Null) Then
                    Return max((local0\Field20[local2]\Field8 / 180.0), 0.13)
                EndIf
                Return 1.0
            EndIf
        EndIf
    Next
    Return 0.125
    Return 0.0
End Function
