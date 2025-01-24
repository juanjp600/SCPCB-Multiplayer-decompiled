Function blitz_mp_readshort0%(arg0.mp_netbuffer)
    If ((arg0\Field1 + $02) > arg0\Field2) Then
        Return $00
    EndIf
    arg0\Field1 = (arg0\Field1 + $02)
    Return peekshort(arg0\Field0, (arg0\Field1 - $02))
    Return $00
End Function
