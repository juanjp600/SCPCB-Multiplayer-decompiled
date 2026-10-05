Function drawtick%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    local0 = (Int (20.0 * menuscale))
    local1 = local0
    local2 = (arg0 And $FF)
    local3 = (arg1 And $FF)
    drawtiledimagerect(menuwhite, local2, local3, 512.0, 512.0, arg0, arg1, local0, local1)
    local4 = (mouseon(arg0, arg1, local0, local1) And (arg3 = $00))
    If (local4 <> 0) Then
        setcolorex($32, $32, $32)
        If (mousehit1 <> 0) Then
            arg2 = (arg2 = $00)
            playsound_strict(buttonsfx)
        EndIf
    Else
        setcolorraw($00)
    EndIf
    rect((arg0 + $02), (arg1 + $02), (local0 - $04), (local1 - $04), $01)
    If (arg2 <> 0) Then
        drawtiledimagerect(menuwhite, local2, local3, 512.0, 512.0, (arg0 + $04), (arg1 + $04), (local0 - $08), (local1 - $08))
    EndIf
    Return arg2
    Return $00
End Function
