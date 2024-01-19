Function se_linkblock%(arg0.se_block, arg1.se_block)
    If (arg1\Field8 <> Null) Then
        arg0\Field5 = arg1\Field8
        arg1\Field8\Field6 = arg0
        arg1\Field8 = arg0
    Else
        arg1\Field7 = arg0
        arg1\Field8 = arg0
    EndIf
    arg0\Field4 = arg1
    Return $00
End Function
