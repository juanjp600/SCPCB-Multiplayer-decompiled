Function voice_countoffset%(arg0%)
    Local local0%
    local0 = zipapi_compress(arg0, $01)
    If (local0 <> $00) Then
        voice\Field15 = ((Float banksize(local0)) / (Float banksize(arg0)))
        freebank(local0)
    EndIf
    Return $00
End Function
