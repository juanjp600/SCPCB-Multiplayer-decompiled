Function updatecheckpointmonitors%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    If (arg0 = $00) Then
        local4 = monitor2
        updatecheckpoint1 = $01
    Else
        local4 = monitor3
        updatecheckpoint2 = $01
    EndIf
    For local0 = $02 To countsurfaces(local4) Step $01
        local1 = getsurface(local4, local0)
        local2 = getsurfacebrush(local1)
        If (local2 <> $00) Then
            local3 = getbrushtexture(local2, $00)
            If (local3 <> $00) Then
                local5 = strippath(texturename(local3))
                If (lower(local5) <> "monitortexture.jpg") Then
                    If (arg0 = $00) Then
                        If (50.0 > monitortimer) Then
                            brushtexture(local2, monitortexture2, $00, $00)
                        Else
                            brushtexture(local2, monitortexture4, $00, $00)
                        EndIf
                    ElseIf (50.0 > monitortimer2) Then
                        brushtexture(local2, monitortexture2, $00, $00)
                    Else
                        brushtexture(local2, monitortexture3, $00, $00)
                    EndIf
                    paintsurface(local1, local2)
                EndIf
                If (local5 <> "") Then
                    freetexture(local3)
                EndIf
            EndIf
            freebrush(local2)
        EndIf
    Next
    Return $00
End Function
