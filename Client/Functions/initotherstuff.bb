Function initotherstuff%()
    Local local0%
    Local local1%
    me\Field9 = $01
    me\Field43 = $FFFFFFFF
    opt\Field16 = opt\Field17
    chs\Field4 = 2.0
    If (opt\Field54 <> 0) Then
        initcheats()
    EndIf
    as\Field1 = 8400.0
    If (selecteddifficulty\Field3 <> $00) Then
        opt\Field37 = $00
    EndIf
    Return $00
End Function
