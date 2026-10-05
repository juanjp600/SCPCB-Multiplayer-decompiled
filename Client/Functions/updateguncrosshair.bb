Function updateguncrosshair%(arg0#)
    Local local0%
    Local local1%
    Local local2#
    Local local3%
    Local local4%
    If ((((hudenabled And (eqquipedgun\Field0 < $0B)) And ((1.0 > (Float eqquipedgun\Field31)) Or (eqquipedgun\Field0 = $05))) And (0.0 = eqquipedgun\Field5)) <> 0) Then
        local0 = viewport_center_x
        local1 = viewport_center_y
        local2 = max(0.0, arg0)
        local3 = imenuscale[$0A]
        local4 = (Int ((Float local3) + local2))
        setcolorraw($00)
        rect(((local0 - local4) - local3), (local1 - $01), (local3 + $02), $03, $01)
        rect(((local0 + local4) - $01), (local1 - $01), (local3 + $02), $03, $01)
        rect((local0 - $01), ((local1 - local4) - local3), $03, (local3 + $02), $01)
        rect((local0 - $01), ((local1 + local4) - $01), $03, (local3 + $02), $01)
        setcolorraw($FFFFFF)
        rect((((local0 - local4) - local3) + $01), local1, local3, $01, $01)
        rect((local0 + local4), local1, local3, $01, $01)
        rect(local0, (((local1 - local4) - local3) + $01), $01, local3, $01)
        rect(local0, (local1 + local4), $01, local3, $01)
    EndIf
    Return $00
End Function
