Function changeoptiontab%(arg0%, arg1%)
    If (arg1 <> 0) Then
        mm\Field5 = arg0
    Else
        igm\Field2 = arg0
        shoulddeletegadgets = $01
    EndIf
    resetinput()
    Return $00
End Function
