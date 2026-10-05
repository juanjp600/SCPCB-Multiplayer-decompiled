Function drawprojectedimage%(arg0%, arg1%, arg2%)
    Local local0#
    Local local1#
    Local local2#
    If (arg2 <> $00) Then
        cameraproject(arg1, entityx(arg2, $00), entityy(arg2, $00), entityz(arg2, $00))
        local0 = projectedz()
        If (0.0 <= local0) Then
            local1 = projectedx()
            local2 = projectedy()
            drawblock(arg0, (Int local1), (Int local2), $00)
        EndIf
    EndIf
    Return $00
End Function
