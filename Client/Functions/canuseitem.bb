Function canuseitem%(arg0%, arg1%, arg2%)
    If (((arg1 = $00) And ((wi\Field0 > $00) Lor (i_1499\Field0 > $00))) <> 0) Then
        createmsg(getlocalstring("msg", "mask.use"), 6.0)
        selecteditem = Null
        Return $00
    ElseIf (((arg0 = $00) And ((wi\Field5 > $00) Lor (wi\Field9 > $00))) <> 0) Then
        createmsg(getlocalstring("msg", "gear.use"), 6.0)
        selecteditem = Null
        Return $00
    ElseIf (((arg2 = $00) And (wi\Field2 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "suit.use"), 6.0)
        selecteditem = Null
        Return $00
    EndIf
    Return $01
    Return $00
End Function
