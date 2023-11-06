# Parallel GPU based Shortest Path in Graph Algorithms 
# Implement parallel GPU based algorithms to compute shortest paths (single source, or all pairs).



<img width="258" alt="image" src="https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/d81ecee4-ac01-453e-b67a-e174804f8afb">


 Input:
 
	A weighted graph 
 
	A source vertex 
 
 Output:
 
	Finding the shortest path from 
 
	source vertex  to all other vertices.
	 

# Dijkstra’s algorithm
 
Each vertex is processed one by one

Sequential in itself

Time complexity

<math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑂</mi>
  <mfenced mathcolor="#3F3F3F" separators="|">
    <mrow>
      <mfenced mathcolor="#3F3F3F" open="|" close="|" separators="|">
        <mrow>
          <mi mathvariant="italic" mathcolor="#3F3F3F">𝐸</mi>
        </mrow>
      </mfenced>
      <mo mathcolor="#3F3F3F">+</mo>
      <mfenced mathcolor="#3F3F3F" open="|" close="|" separators="|">
        <mrow>
          <mi mathvariant="italic" mathcolor="#3F3F3F">𝑉</mi>
        </mrow>
      </mfenced>
      <mrow>
        <mrow>
          <mi mathvariant="normal" mathcolor="#3F3F3F">log</mi>
        </mrow>
        <mo mathcolor="#3F3F3F">⁡</mo>
        <mrow>
          <mfenced mathcolor="#3F3F3F" open="|" close="|" separators="|">
            <mrow>
              <mi mathvariant="italic" mathcolor="#3F3F3F">𝑉</mi>
            </mrow>
          </mfenced>
        </mrow>
      </mrow>
    </mrow>
  </mfenced>
</math>


# The Bellman-Ford algorithm
 
All vertices are processed for  times

Time complexity

<math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑂</mi>
  <mo stretchy="false" mathcolor="#3F3F3F">(</mo>
  <mfenced mathcolor="#3F3F3F" open="|" close="|" separators="|">
    <mrow>
      <mi mathvariant="italic" mathcolor="#3F3F3F">𝐸</mi>
    </mrow>
  </mfenced>
  <mfenced mathcolor="#3F3F3F" open="|" close="|" separators="|">
    <mrow>
      <mi mathvariant="italic" mathcolor="#3F3F3F">𝑉</mi>
    </mrow>
  </mfenced>
  <mo stretchy="false" mathcolor="#3F3F3F">)</mo>
</math>

# Sequential Bellman-Ford algorithm

Maintain <math xmlns="http://www.w3.org/1998/Math/MathML"> for all <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">∈</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑉</mi>
</math>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  <mi mathcolor="#3F3F3F"> </mi>
</math>

 shortest path weight estimate
 ￼ records tentative shortest path weight from source vertex ￼ to vertex ￼.
 ￼records the actual shortest path distance in the end.
