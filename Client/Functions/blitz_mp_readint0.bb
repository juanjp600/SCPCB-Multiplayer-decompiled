Function blitz_mp_readint0%(arg0.mp_netbuffer)
    If ((arg0\Field1 + $04) > arg0\Field2) Then
        Return $00
    EndIf
    arg0\Field1 = (arg0\Field1 + $04)
    Return peekint(arg0\Field0, (arg0\Field1 - $04))
    Return $00
End Function
