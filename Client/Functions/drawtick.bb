Function drawtick%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    local0 = (Int (20.0 * menuscale))
    local1 = (Int (20.0 * menuscale))
    color($FF, $FF, $FF)
    drawtiledimagerect(menuwhite, (arg0 Mod $100), (arg1 Mod $100), 512.0, 512.0, arg0, arg1, local0, local1)
    local2 = (mouseon(arg0, arg1, local0, local1) And (arg3 = $00))
    If (local2 <> 0) Then
        color($32, $32, $32)
        If (mousehit1 <> 0) Then
            arg2 = (arg2 = $00)
            playsound_strict(buttonsfx)
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    rect((arg0 + $02), (arg1 + $02), (local0 - $04), (local1 - $04), $01)
    If (arg2 <> 0) Then
        If (local2 <> 0) Then
            color($FF, $FF, $FF)
        Else
            color($C8, $C8, $C8)
        EndIf
        drawtiledimagerect(menuwhite, (arg0 Mod $100), (arg1 Mod $100), 512.0, 512.0, (arg0 + $04), (arg1 + $04), (local0 - $08), (local1 - $08))
    EndIf
    color($FF, $FF, $FF)
    Return arg2
    Return $00
End Function
