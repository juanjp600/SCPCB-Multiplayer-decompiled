Function aastringheight%(arg0$)
    Local local0.aafont
    local0 = (Object.aafont aaselectedfont)
    If ((aatextenable And local0\Field12) <> 0) Then
        Return local0\Field10
    Else
        setfont(local0\Field7)
        Return stringheight(arg0)
    EndIf
    Return $00
End Function
