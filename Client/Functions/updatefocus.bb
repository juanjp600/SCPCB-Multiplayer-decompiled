Function updatefocus%()
    Local local0%
    Local local1%
    Local local2%
    local0 = millisecs()
    If (local0 < focuschecktimer) Then
        Return infocus
    EndIf
    focuschecktimer = (local0 + $64)
    local1 = api_getforegroundwindow()
    local2 = (local1 = win\Field0)
    If (local2 <> infocus) Then
        infocus = local2
        If (infocus = $00) Then
            menu_open_type = $02
            flushkeys()
            flushmouse()
        Else
            menu_open_type = menuopen
        EndIf
    EndIf
    Return infocus
    Return $00
End Function
