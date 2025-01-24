Function preventitemoverlapping%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%)
    If (((arg0 = $00) And (wi\Field0 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "mask.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg2 = $00) And (i_1499\Field0 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "1499.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg1 = $00) And (wi\Field5 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "goggle.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg3 = $00) And wi\Field4) <> 0) Then
        createmsg(getlocalstring("msg", "helmet.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg4 = $00) And (wi\Field9 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "gear.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg5 = $00) And (wi\Field2 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "suit.use.off"), 6.0)
        selecteditem = Null
        Return $01
    ElseIf (((arg6 = $00) And (i_268\Field0 > $00)) <> 0) Then
        createmsg(getlocalstring("msg", "cap.use.off"), 6.0)
        selecteditem = Null
        Return $01
    EndIf
    Return $00
    Return $00
End Function
