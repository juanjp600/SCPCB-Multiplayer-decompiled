Function blitz_mp_readfloat0#(arg0.mp_netbuffer)
    If ((arg0\Field1 + $04) > arg0\Field2) Then
        Return 0.0
    EndIf
    arg0\Field1 = (arg0\Field1 + $04)
    Return peekfloat(arg0\Field0, (arg0\Field1 - $04))
    Return 0.0
End Function
