Function updateguncrosshair%(arg0#)
    Local local0#
    If (spectate\Field1 = $FFFFFFFF) Then
        If (hudenabled <> 0) Then
            If (eqquipedgun\Field0 < $0B) Then
                local0 = max(-16.0, arg0)
                color($FF, $FF, $FF)
                rect((Int ((Float ((graphicwidth Sar $01) - $14)) - local0)), (graphicheight Sar $01), $0A, $01, $01)
                rect((Int ((Float ((graphicwidth Sar $01) + $0A)) + local0)), (graphicheight Sar $01), $0A, $01, $01)
                rect((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) - $14)) - local0)), $01, $0A, $01)
                rect((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) + $0A)) + local0)), $01, $0A, $01)
                rect((Int ((Float ((graphicwidth Sar $01) - $14)) - local0)), (graphicheight Sar $01), $0A, $01, $01)
                rect((Int ((Float ((graphicwidth Sar $01) + $0A)) + local0)), (graphicheight Sar $01), $0A, $01, $01)
                rect((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) - $14)) - local0)), $01, $0A, $01)
                rect((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) + $0A)) + local0)), $01, $0A, $01)
            EndIf
        EndIf
    EndIf
    Return $00
End Function
