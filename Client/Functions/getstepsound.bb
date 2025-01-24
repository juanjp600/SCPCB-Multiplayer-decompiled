Function getstepsound%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5.materials
    local0 = linepick(entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00), 0.0, -1.0, 0.0, 0.0)
    If (local0 <> $00) Then
        If (getentitytype(local0) <> $01) Then
            Return $00
        EndIf
        local1 = getsurfacebrush(getsurface(local0, countsurfaces(local0)))
        If (local1 <> $00) Then
            local2 = $03
            While (local2 >= $01)
                local3 = getbrushtexture(local1, local2)
                If (local3 <> $00) Then
                    local4 = strippath(texturename(local3))
                    freetexture(local3)
                    local3 = $00
                    If (local4 <> "") Then
                        For local5 = Each materials
                            If (local5\Field0 = local4) Then
                                freebrush(local1)
                                local1 = $00
                                Return local5\Field4
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                local2 = (local2 + $FFFFFFFF)
            Wend
            freebrush(local1)
            local1 = $00
        EndIf
    EndIf
    Return $00
    Return $00
End Function
