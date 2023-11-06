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


<img width="299" alt="image" src="https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/72389229-6855-48ce-857e-fb99e8da060e">


Maintain <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  <mi mathcolor="#3F3F3F"> </mi>
</math> for all <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">∈</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑉</mi>
</math>

 shortest path weight estimate 
 
 <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  </math> records tentative shortest path weight from source vertex <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑠</mi>
  </math>to vertex<math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  </math>


  <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  </math> records the actual shortest path distance in the end.



Technique of <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑟</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑒</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑙</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑎</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑥</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑎</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑡</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑖</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑜</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑛</mi>
  </math>


 used to process edges <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mo stretchy="false" mathcolor="#3F3F3F">(</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑢</mi>
  <mo mathcolor="#3F3F3F">,</mo>
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo stretchy="false" mathcolor="#3F3F3F">)</mo>
  </math>

<math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑅</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝐸</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝐿</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝐴</mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑋</mi>
  <mo stretchy="false" mathcolor="#3F3F3F">(</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑢</mi>
  <mo mathcolor="#3F3F3F">,</mo>
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">,</mo>
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑤</mi>
  <mo stretchy="false" mathcolor="#3F3F3F">)</mo>
  </math>



  update <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  </math> with <math xmlns="http://www.w3.org/1998/Math/MathML">
  <mi mathvariant="normal" mathcolor="#3F3F3F">m</mi>
  <mi mathvariant="normal" mathcolor="#3F3F3F">i</mi>
  <mi mathvariant="normal" mathcolor="#3F3F3F">n</mi>
  <mo mathcolor="#3F3F3F">⁡</mo>
  <mo stretchy="false" mathcolor="#3F3F3F">(</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  <mo mathcolor="#3F3F3F">,</mo>
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathcolor="#3F3F3F"> </mi>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑢</mi>
  <mo mathcolor="#3F3F3F">.</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑑</mi>
  <mo mathcolor="#3F3F3F">+</mo>
  <mi mathvariant="italic" mathcolor="#3F3F3F">𝑤</mi>
  <mfenced mathcolor="#3F3F3F" separators="|">
    <mrow>
      <mo stretchy="false" mathcolor="#3F3F3F">(</mo>
      <mi mathvariant="italic" mathcolor="#3F3F3F">𝑢</mi>
      <mo mathcolor="#3F3F3F">,</mo>
      <mi mathcolor="#3F3F3F"> </mi>
      <mi mathvariant="italic" mathcolor="#3F3F3F">𝑣</mi>
      <mo stretchy="false" mathcolor="#3F3F3F">)</mo>
    </mrow>
  </mfenced>
  <mo stretchy="false" mathcolor="#3F3F3F">)</mo>
</math>

<img width="436" alt="image" src="https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/d289fdd1-2161-46d3-98a1-851576f8da76">

![image](https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/5dde434d-1719-4a42-ad2a-efd3a83b32b8)

![image](https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/68fea6f1-5b36-4e69-b430-754d51960f4d)



# Basic parallel implementation of Bellman Ford using CUDA

![image](https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/7eb83352-6b92-46dd-94e9-1311279964e6)


![image](https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/bebc6f53-c5e4-40aa-a7ee-241ad8a19575)


# Improved Parallel Implementation of Bellman Ford using CUDA

![image](https://github.com/babsubra1980/Final-Project---Parallel-Algorithms-Class/assets/37005639/008f7574-a9ba-404c-a157-afc3080ca52d)



