Function entityscalex#(arg0%, arg1%)
    Local local0#
    Local local1#
    Local local2#
    If (arg1 <> 0) Then
        local0 = getmatelement(arg0, $00, $00)
        local1 = getmatelement(arg0, $00, $01)
        local2 = getmatelement(arg0, $00, $02)
    Else
        tformvector(1.0, 0.0, 0.0, arg0, getparent(arg0))
        Return sqr((((tformedx() * tformedx()) + (tformedy() * tformedy())) + (tformedz() * tformedz())))
    EndIf
    Return sqr((((local0 * local0) + (local1 * local1)) + (local2 * local2)))
    Return 0.0
End Function
