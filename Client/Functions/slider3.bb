Function slider3%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5$, arg6$, arg7$)
    If (mousedown1 <> 0) Then
        If (((((scaledmousex() >= arg0) And (scaledmousex() <= ((arg0 + arg2) + $0E))) And (scaledmousey() >= (arg1 - $08))) And (scaledmousey() <= (arg1 + $0A))) <> 0) Then
            onsliderid = arg4
        EndIf
    EndIf
    color($C8, $C8, $C8)
    rect(arg0, arg1, (arg2 + $0E), $0A, $01)
    rect(arg0, (arg1 - $08), $04, $0E, $01)
    rect((((arg2 Sar $01) + arg0) + $05), (arg1 - $08), $04, $0E, $01)
    rect(((arg0 + arg2) + $0A), (arg1 - $08), $04, $0E, $01)
    If (arg4 = onsliderid) Then
        If (scaledmousex() <= (arg0 + $08)) Then
            arg3 = $00
        ElseIf (((scaledmousex() >= ((arg2 Sar $01) + arg0)) And (scaledmousex() <= (((arg2 Sar $01) + arg0) + $08))) <> 0) Then
            arg3 = $01
        ElseIf (scaledmousex() >= (arg0 + arg2)) Then
            arg3 = $02
        EndIf
        color($00, $FF, $00)
        rect(arg0, arg1, (arg2 + $0E), $0A, $01)
    ElseIf (((((scaledmousex() >= arg0) And (scaledmousex() <= ((arg0 + arg2) + $0E))) And (scaledmousey() >= (arg1 - $08))) And (scaledmousey() <= (arg1 + $0A))) <> 0) Then
        color($00, $C8, $00)
        rect(arg0, arg1, (arg2 + $0E), $0A, $00)
    EndIf
    If (arg3 = $00) Then
        drawimage(blinkmeterimg, arg0, (arg1 - $08), $00)
    ElseIf (arg3 = $01) Then
        drawimage(blinkmeterimg, (((arg2 Sar $01) + arg0) + $03), (arg1 - $08), $00)
    Else
        drawimage(blinkmeterimg, ((arg0 + arg2) + $06), (arg1 - $08), $00)
    EndIf
    color($AA, $AA, $AA)
    If (arg3 = $00) Then
        aatext((arg0 + $02), (Int ((Float (arg1 + $0A)) + menuscale)), arg5, $01, $00, 1.0)
    ElseIf (arg3 = $01) Then
        aatext((((arg2 Sar $01) + arg0) + $07), (Int ((Float (arg1 + $0A)) + menuscale)), arg6, $01, $00, 1.0)
    Else
        aatext(((arg0 + arg2) + $0C), (Int ((Float (arg1 + $0A)) + menuscale)), arg7, $01, $00, 1.0)
    EndIf
    Return arg3
    Return $00
End Function
