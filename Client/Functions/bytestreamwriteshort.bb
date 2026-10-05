Function bytestreamwriteshort%(arg0.bs, arg1%)
    If (iscoopmode() <> 0) Then
        udp_writeshort(arg1)
    Else
        arg0\Field2 = (arg0\Field2 + $02)
        arg0\Field1 = (arg0\Field1 + $02)
        pokeshort(arg0\Field0, (arg0\Field1 - $02), arg1)
    EndIf
    Return $00
End Function
