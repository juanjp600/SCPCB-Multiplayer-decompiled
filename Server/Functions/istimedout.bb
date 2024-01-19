Function istimedout%(arg0%, arg1%)
    Local local0%
    local0 = (millisecs_sys[arg0] <= millisecs())
    If (local0 <> 0) Then
        startouttimer(arg0, arg1)
    EndIf
    Return local0
    Return $00
End Function
