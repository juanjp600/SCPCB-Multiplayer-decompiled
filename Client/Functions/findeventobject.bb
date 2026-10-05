Function findeventobject%(arg0.events)
    Local local0%
    If (((udp_getstream() = $00) Or (arg0\Field1 = Null)) <> 0) Then
        arg0\Field14 = networkserver\Field20
        Return collider
    EndIf
    If (((arg0\Field21 >= networkserver\Field21) Or ((arg0\Field14 + $01) = (networkserver\Field52\Field14 + $01))) <> 0) Then
        arg0\Field14 = $00
        arg0\Field21 = $00
    EndIf
    For local0 = (arg0\Field14 + $01) To networkserver\Field52\Field14 Step $01
        If (player[local0] <> Null) Then
            arg0\Field21 = (arg0\Field21 + $01)
            If (((player[local0]\Field45 = arg0\Field1\Field65) And (player[local0]\Field31 = $00)) <> 0) Then
                arg0\Field14 = local0
                Return player[arg0\Field14]\Field13
            EndIf
        EndIf
    Next
    If (player[arg0\Field14] = Null) Then
        arg0\Field14 = networkserver\Field20
    EndIf
    Return player[arg0\Field14]\Field13
    Return $00
End Function
