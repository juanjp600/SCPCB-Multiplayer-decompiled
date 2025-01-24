Function loadspritefont.spritefont(arg0$, arg1$, arg2#, arg3#)
    Local local0%
    Local local1.spritefont
    local0 = loadfont(arg1, (Int arg2))
    If (local0 = $00) Then
        Return Null
    EndIf
    local1 = (New spritefont)
    local1\Field0 = arg0
    local1\Field1 = local0
    local1\Field2 = arg3
    local1\Field3 = max(arg2, 1.0)
    Return local1
    Return Null
End Function
