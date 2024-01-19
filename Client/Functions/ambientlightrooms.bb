Function ambientlightrooms%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (arg0 = ambientlightroomval) Then
        Return $00
    EndIf
    ambientlightroomval = arg0
    local4 = backbuffer()
    setbuffer(texturebuffer(ambientlightroomtex, $00))
    clscolor(arg0, arg0, arg0)
    cls()
    clscolor($00, $00, $00)
    setbuffer(local4)
    Return $00
End Function
